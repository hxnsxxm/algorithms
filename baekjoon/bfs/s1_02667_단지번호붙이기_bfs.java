import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_02667_단지번호붙이기_bfs {

    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static class Position {
        int r;
        int c;
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public int getR() { return r; }
        public int getC() { return c; }
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s1_02667.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int cnt = 0;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] columns = br.readLine().toCharArray();
            for (int j = 0; j < columns.length; j++) {
                map[i][j] = columns[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt += 1;
                    bfs(i, j);
                }
            }
        }

        sb.append(cnt).append("\n");
        Collections.sort(answer);
        for (int ans : answer) {
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(int r, int c) {
        Queue<Position> queue = new LinkedList<>();
        int cnt = 1;

        visited[r][c] = true;
        queue.add(new Position(r, c));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (int d = 0; d < 4; d++) {
                int tr = pos.getR() + dr[d];
                int tc = pos.getC() + dc[d];
                if (!outOfRange(tr, tc) && !visited[tr][tc] && map[tr][tc] == 1) {
                    visited[tr][tc] = true;
                    cnt += 1;
                    queue.add(new Position(tr, tc));
                }
            }
        }

        answer.add(cnt);
    }

    public static boolean outOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }
}
