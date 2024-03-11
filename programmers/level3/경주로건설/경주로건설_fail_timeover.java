package level3.경주로건설;

/**
 * - 최대 배열의 크기가 25인 정사각 배열에 dfs를 사용하면 시간초과?
 *
 * 테스트 1 〉	통과 (0.09ms, 66.9MB)
 * 테스트 2 〉	통과 (0.06ms, 72.4MB)
 * 테스트 3 〉	통과 (0.08ms, 71.1MB)
 * 테스트 4 〉	통과 (0.06ms, 75MB)
 * 테스트 5 〉	통과 (0.09ms, 75.2MB)
 * 테스트 6 〉	실패 (시간 초과)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	실패 (시간 초과)
 * 테스트 10 〉	실패 (시간 초과)
 * 테스트 11 〉	실패 (시간 초과)
 * 테스트 12 〉	실패 (시간 초과)
 * 테스트 13 〉	통과 (2.48ms, 77.8MB)
 * 테스트 14 〉	통과 (40.55ms, 83.2MB)
 * 테스트 15 〉	실패 (시간 초과)
 * 테스트 16 〉	실패 (시간 초과)
 * 테스트 17 〉	실패 (시간 초과)
 * 테스트 18 〉	실패 (시간 초과)
 * 테스트 19 〉	실패 (시간 초과)
 * 테스트 20 〉	통과 (4.53ms, 67.8MB)
 * 테스트 21 〉	통과 (2.79ms, 84.4MB)
 * 테스트 22 〉	통과 (0.28ms, 73.9MB)
 * 테스트 23 〉	통과 (0.10ms, 69.7MB)
 * 테스트 24 〉	통과 (0.07ms, 75MB)
 * 테스트 25 〉	통과 (0.07ms, 72.8MB)
 */
public class 경주로건설_fail_timeover {

    int N;
    int[][] map;
    boolean[][] visited;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int[] pre = new int[2]; //2칸 전 좌표
    int cost;
    int result = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = 0;

        map = board;
        N = board.length;
        visited = new boolean[N][N];
        visited[0][0] = true;

        dfs(0, 0);

        //System.out.println("end");
        return result;
    }

    void dfs(int r, int c) {
        if (r == N - 1 && c == N - 1) {
            result = Math.min(result, cost);
            //System.out.println("*****");
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];

            if (!outOfRange(tr, tc) && !visited[tr][tc] && map[tr][tc] != 1) {
                visited[tr][tc] = true;
                int[] backup = pre.clone();
                int tmp = straightValue() + conerValue(tr, tc, r, c);
                cost += tmp;

                //System.out.println(cost);
                //System.out.println("(" + tr + ", " + tc + ")");
                dfs(tr, tc);

                cost -= tmp;
                pre = backup;
                visited[tr][tc] = false;
            }
        }
    }

    boolean outOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }

    int straightValue() {
        return 100;
    }

    int conerValue(int tr, int tc, int r, int c) {
        int value = 0;
        if (Math.abs(tr - pre[0]) >= 1 && Math.abs(tc - pre[1]) >= 1) {
            pre[0] = r;
            pre[1] = c;
            value = 500;
        }

        return value;
    }
}
