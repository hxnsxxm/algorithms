package level2.거리두기확인하기;

public class 거리두기확인하기 {

    char[][] map = new char[5][5];
    int len = 5;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    boolean[][] visited;
    int[] result = {1, 1, 1, 1, 1};
    int seq;


    public int[] solution(String[][] places) {
        int[] answer = {};



        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[j] = places[i][j].toCharArray();
                //System.out.println(Arrays.toString(map[j]));
            }

            //System.out.println();
            seq = i;
            solve();

        }

        return result;
    }

    void solve() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                visited = new boolean[5][5];
                if (map[i][j] == 'P') {
                    visited[i][j] = true;
                    //System.out.println("start (" + i + ", " + j + ")");
                    bt(i, j, 0);
                }
                if (result[seq] == 0)
                    return;
            }
        }
    }

    void bt(int r, int c, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];
            if (!outOfRange(tr, tc) && !visited[tr][tc]) {
                visited[tr][tc] = true;
                if (map[tr][tc] == 'P') {
                    //System.out.println("false : (" + tr + ", " + tc + ")");
                    result[seq] = 0;
                    return;
                }
                if (map[tr][tc] == 'O') {
                    bt(tr, tc, depth + 1);
                }
                visited[tr][tc] = false;
            }
        }
    }

    boolean outOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= 5 || c >= 5;
    }
}
