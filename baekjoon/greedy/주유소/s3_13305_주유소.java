package 주유소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_13305_주유소 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("greedy/input/s3_13305.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cities = new int[N-1][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            cities[i][1] = Integer.parseInt(st.nextToken()); // 도시 간 거리
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            cities[i][0] = Integer.parseInt(st.nextToken()); // 리터당 가격
        }

        long sum = 0;
        long minCost = cities[0][0];

        for (int i = 0; i < N - 1; i++) {
            if (cities[i][0] < minCost) {
                minCost = cities[i][0];
            }

            sum += minCost * cities[i][1];
        }

        System.out.print(sum);
    }
}
