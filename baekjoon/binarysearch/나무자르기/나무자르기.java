package binarysearch.나무자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 나무자르기 {

    static int N;
    static long M;
    static int[] trees;
    static long max;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/binarysearch/나무자르기/s2_02805.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        System.out.println(bSearch());
    }

    static long bSearch() {
        long bottom = 0;
        long top = max + 1;
        long mid = 0;

        while (bottom < top) {
            mid = bottom + (top - bottom)/2;
            System.out.print(top + ", " + bottom + ", " + mid);
            long sum = 0;

            for (int h : trees) {
                if (h > mid)
                    sum += h - mid;
            }
            System.out.println(" >> sum : " + sum);

            if (sum < M)
                top = mid;
            else
                bottom = mid + 1;
        }

        return bottom - 1;
    }
}

