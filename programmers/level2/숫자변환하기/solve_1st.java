package level2.숫자변환하기;

import java.util.Arrays;

public class solve_1st {
    class Solution {
        public int solution(int x, int y, int n) {
            int answer = 0;

            int[] dp = new int[y + 1];
            Arrays.fill(dp, -1);
            dp[x] = 0;
            if (2*x <= y)
                dp[2 * x] = 1;
            if (3*x <= y)
                dp[3 * x] = 1;
            if (x + n <= y)
                dp[x + n] = 1;

            for (int i = x + 1; i <= y; i++) {
                if (i - n > 0 && dp[i - n] >= 0) {
                    dp[i] = dp[i - n] + 1;
                }
                if (i%2 == 0 && dp[i/2] >= 0) {
                    dp[i] = dp[i/2] + 1;
                    if (i - n >= x && dp[i - n] >= 0)
                        dp[i] = Math.min(dp[i/2], dp[i - n]) + 1;
                }
                if (i%3 == 0 && dp[i/3] >= 0) {
                    dp[i] = dp[i/3] + 1;
                    if (i - n >= x && dp[i - n] >= 0)
                        dp[i] = Math.min(dp[i/3], dp[i - n]) + 1;
                }
                if (i%6 == 0 && dp[i/2] >= 0 && dp[i/3] >= 0) {
                    dp[i] = Math.min(dp[i/2], dp[i/3]) + 1;
                    if (i - n >= x && dp[i - n] >= 0) {
                        dp[i] = Math.min(dp[i/2], Math.min(dp[i/3], dp[i - n])) + 1;
                    }
                }
            }
            //System.out.println(Arrays.toString(dp));
            answer = dp[y];

            return answer;
        }
    }
}
