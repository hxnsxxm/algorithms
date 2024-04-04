package level2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class solve_1st {
    class Solution {

        int n;
        int m;
        int[] dn = {0, 1, 0, -1};
        int[] dm = {1, 0, -1, 0};

        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;

            bfs(maps);

            if (maps[n - 1][m - 1] == 1)
                return -1;
            return maps[n - 1][m - 1];
        }

        void bfs(int[][] maps) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int tn = pos[0] + dn[i];
                    int tm = pos[1] + dm[i];

                    if (tn < 0 || tm < 0 || tn >= n || tm >= m)
                        continue;
                    if (maps[tn][tm] > 1 || maps[tn][tm] == 0)
                        continue;

                    maps[tn][tm] += maps[pos[0]][pos[1]];
                    queue.add(new int[]{tn, tm});
                }
            }
        }
    }
}
