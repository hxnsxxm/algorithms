package level2.프렌즈4블록;

import java.util.LinkedList;
import java.util.Queue;

public class solve_1st {
    class Solution {

        boolean[][] counted;
        char[][] map;
        int M;
        int N;

        public int solution(int m, int n, String[] board) {
            int answer = 0;

            M = m;
            N = n;
            counted = new boolean[M][N];
            map = new char[M][N];
            for (int i = 0; i < M; i++)
                map[i] = board[i].toCharArray();

            while (check()) {
                //check();
                // for (boolean[] c : counted)
                //     System.out.println(Arrays.toString(c));
                answer += countAndRemove();
                // for (char[] c : map)
                //     System.out.println(Arrays.toString(c));
                // System.out.println("*****");
                drop();
                // for (char[] c : map)
                //     System.out.println(Arrays.toString(c));
                counted = new boolean[M][N];
            }

            return answer;
        }

        boolean check() {
            boolean flag = false;
            for (int m = 0; m < M - 1; m++) {
                for (int n = 0; n < N - 1; n++) {
                    if (map[m][n] == '-') continue;
                    if (map[m][n] != map[m][n + 1]) continue;
                    if (map[m][n] != map[m + 1][n]) continue;
                    if (map[m][n] != map[m + 1][n + 1]) continue;
                    counted[m][n] = counted[m][n + 1] = counted[m + 1][n] = counted[m + 1][n + 1] = true;
                    flag = true;
                }
            }

            if (flag)
                return true;
            return false;
        }

        int countAndRemove() {
            int cnt = 0;
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (counted[m][n]) {
                        cnt++;
                        map[m][n] = '-';
                    }
                }
            }

            return cnt;
        }

        void drop() {
            for (int n = 0; n < N; n++) {
                Queue<Integer> q = new LinkedList<>();
                for (int m = M - 1; m >= 0; m--) {
                    if (map[m][n] == '-')
                        q.add(m);
                    else if (!q.isEmpty()) {
                        map[q.poll()][n] = map[m][n];
                        map[m][n] = '-';
                        q.add(m);
                    }
                }
            }
        }
    }
}
