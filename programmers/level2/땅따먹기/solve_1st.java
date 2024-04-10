package level2.땅따먹기;

public class solve_1st {
    class Solution {
        int solution(int[][] land) {
            int answer = 0;

            int len = land.length;
            int[][] dp = new int[len][4];

            dp[len - 1] = land[len - 1];

            for (int i = len - 1; i > 0; i--) {
                dp[i - 1][0] = land[i - 1][0] + Math.max(dp[i][1], Math.max(dp[i][2], dp[i][3]));
                dp[i - 1][1] = land[i - 1][1] + Math.max(dp[i][0], Math.max(dp[i][2], dp[i][3]));
                dp[i - 1][2] = land[i - 1][2] + Math.max(dp[i][0], Math.max(dp[i][1], dp[i][3]));
                dp[i - 1][3] = land[i - 1][3] + Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2]));
            }

            answer = Math.max(Math.max(dp[0][0], dp[0][1]), Math.max(dp[0][2], dp[0][3]));

            return answer;
        }
    }
}
