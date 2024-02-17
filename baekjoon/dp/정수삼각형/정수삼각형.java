package 정수삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 정수삼각형 {

    static int[] inputs;
    static int N;
    static int len;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/정수삼각형/1932.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        len = N*(N + 1)/2;
        inputs = new int[len + 1];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                inputs[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp());
    }

    static int dp() {
        int[] tabular = new int[len + 1];

        for (int i = len; i > len - N; i--) {
            tabular[i] = inputs[i];
        }

        int idx = len - N;
        for (int i = N; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                tabular[idx] = Math.max(tabular[idx + i], tabular[idx + i - 1]) + inputs[idx];
                //System.out.println("idx: " + idx + ", " + tabular[idx]);
                idx--;
            }
        }

        return tabular[1];
    }
}
