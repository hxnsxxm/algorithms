package 피보나치함수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 피보나치함수 {

    static int[][] result;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/피보나치함수/s3_01003.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        result = new int[T][2];
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            //fibonacci(t, n);
            //System.out.println(result[t][0] + " " + result[t][1]);
            fibonacci_bottom_up(n);
        }
    }

    static int fibonacci(int t, int n) {
        if (n == 0) {
            result[t][0] += 1;
            return 1;
        }
        if (n == 1) {
            result[t][1] += 1;
            return 1;
        }

        return fibonacci(t, n - 1) + fibonacci(t, n - 2);
    }

    static void fibonacci_bottom_up(int n) {
        int[][] tabular = new int[41][2];

        tabular[0] = new int[]{1, 0};
        tabular[1] = new int[]{0, 1};

        for (int i = 2; i <= n; i++) {
            tabular[i][0] = tabular[i - 2][0] + tabular[i - 1][0];
            tabular[i][1] = tabular[i - 2][1] + tabular[i - 1][1];
        }

        System.out.println(tabular[n][0] + " " + tabular[n][1]);
    }
}
