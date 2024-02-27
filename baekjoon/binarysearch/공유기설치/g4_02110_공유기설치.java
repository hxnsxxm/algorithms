package binarysearch.공유기설치;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_02110_공유기설치 {

    static int N;
    static int C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("binarysearch/공유기설치/g4_02110.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int min = 1;
        int max = houses[N - 1] - houses[0] + 1;

        while (min < max) {
            int mid = (min + max)/2;

            if (canInstall(mid) < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.print(min - 1);
    }

    static int canInstall(int distance) {
        int count = 1;
        int lastLocate = houses[0];

        for (int i = 1; i < N; i++) {
            int locate = houses[i];

            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
