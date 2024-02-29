package 주유소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 주유소 {

    static int N;
    static long[] distance;
    static long[] oil;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/주유소/s3_13305.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        distance = new long[N - 1];
        oil = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        long minCost = oil[0];
        for (int i = 0; i < N - 1; i++) {
            if (minCost > oil[i])
                minCost = oil[i];

            result += minCost * distance[i];
        }

        System.out.print(result);
    }
}
