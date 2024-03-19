package binarysearch.나무자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class solve_3rd {

    static int N;
    static int M;
    static int[] trees;
    static int max;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/binarysearch/나무자르기/s2_02805.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        System.out.println(bs());
        System.out.println(reverse());
    }

    static int bs() {
        int left = 0;
        int right = max + 1;

        while (left < right) {
            int mid = left + (right - left)/2;
            int sum = 0;

            for (int t : trees) {
                if (t > mid) {
                    sum += t - mid;
                }
            }

            if (sum < M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int reverse() {
        int right = 0;
        int left = max + 1;

        while (right < left) {
            int mid = right + (left - right)/2;
            int sum = 0;

            for (int t : trees) {
                if (t > mid)
                    sum += t - mid;
            }
            System.out.println(left + ", " + right + ", " + sum);
            if (sum < M)
                left = mid - 1;
            else
                right = mid;
        }

        return right;
    }
}
