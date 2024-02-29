package 로프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 로프 {

    static int N;
    static Integer[] roaps;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/로프/s4_02217.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        roaps = new Integer[N];
        for (int i = 0; i < N; i++) {
            roaps[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(roaps, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, roaps[i]*(i + 1));
        }

        System.out.print(result);
    }
}
