package binarysearch.공유기설치;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

    static int N;
    static int C;
    static int[] homes;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/binarysearch/공유기설치/g4_02110.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        System.out.println(bSearch());
    }

    static int bSearch() {
        int left = 1;
        int right = homes[N - 1] - homes[0] + 1;
        int mid;

        while (left < right) {
            mid = left + (right - left)/2;
            int cnt = 1;
            int pos = homes[0];

            for (int i = 1; i < N; i++) {
                if (pos + mid <= homes[i]) {
                    cnt++;
                    pos = homes[i];
                }
            }

            if (cnt < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
