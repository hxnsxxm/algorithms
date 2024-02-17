package _123더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _123더하기 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/_123더하기/s3_09095.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(count(n));
            System.out.println(countWays(n));
            System.out.println(count_bottom_up(n));
        }
    }

    static int count(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        return count(n - 1) + count(n - 2) + count(n - 3);
    }

    static int count_bottom_up (int n) {
        int[] tabular = new int[11];

        tabular[1] = 1;
        tabular[2] = 2;
        tabular[3] = 4;

        for (int i = 4; i <= n; i++) {
            tabular[i] = tabular[i - 1] + tabular[i - 2] + tabular[i - 3];
        }

        return tabular[n];
    }

    public static int countWays(int n) {
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 1;

        // 다이나믹 프로그래밍을 이용하여 각 경우의 수 계산
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }

        return dp[n];
    }
}
