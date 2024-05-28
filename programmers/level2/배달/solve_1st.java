package level2.배달;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class solve_1st {
    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 1;

            int[][] times = new int[N + 1][N + 1];
            int INF = 500_001;
            for (int i = 0; i <= N; i++) {
                Arrays.fill(times[i], INF);
                times[i][i] = 0;
            }
            for (int[] r : road) {
                if (times[r[0]][r[1]] <= r[2])
                    continue;

                times[r[0]][r[1]] = r[2];
                times[r[1]][r[0]] = r[2];
            }

            Queue<Integer[]> q = new PriorityQueue<>(new Comparator<Integer[]>(){
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return o1[1] - o2[1];
                }
            });
            boolean[] checked = new boolean[N + 1];
            int[] dp = new int[N + 1];
            Arrays.fill(dp, INF);
            dp[1] = 0;
            q.add(new Integer[]{1, 0});

            while (!q.isEmpty()) {
                Integer[] node = q.poll();
                int to = node[0];

                if (checked[to])
                    continue;
                else
                    checked[to] = true;

                for (int i = 1; i <= N; i++) {
                    if (dp[i] >= dp[to] + times[to][i]) {
                        dp[i] = dp[to] + times[to][i];
                        q.add(new Integer[]{i, dp[i]});
                    }
                }
            }

            for (int i = 2; i <= N; i++) {
                if (dp[i] <= K)
                    answer++;
            }

            return answer;
        }
    }
}
