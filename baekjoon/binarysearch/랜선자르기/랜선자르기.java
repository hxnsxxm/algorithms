package binarysearch.랜선자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 랜선자르기 {

    static int K;
    static int N;
    static long[] lines;
    static long max;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/binarysearch/랜선자르기/s2_01654.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }

        System.out.println(bSearch());
    }

    static long bSearch() {
        long bottom = 0;
        long top = max + 1;
        long mid;

        while (bottom < top) {
            mid = bottom + (top - bottom)/2;
            long sum = 0;

            for (long m : lines) {
                sum += m/mid;
            }

            if (sum < N)
                top = mid;
            else
                bottom = mid + 1;
        }

        return bottom - 1;
    }
}
