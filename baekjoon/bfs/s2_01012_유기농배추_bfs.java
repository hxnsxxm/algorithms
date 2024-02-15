import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_01012_유기농배추_bfs {

    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};

    public static class Position {
        int n;
        int m;
        public Position(int n, int m) {
            this.n = n;
            this.m = m;
        }
        public int getN() { return n; }
        public int getM() { return m; }
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s2_01012.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int source = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());

                map[destination][source] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        cnt += 1;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(int n, int m) {
        Queue<Position> queue = new LinkedList<>();

        visited[n][m] = true;
        queue.add(new Position(n, m));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tn = pos.getN() + dn[i];
                int tm = pos.getM() + dm[i];

                if (!outOfRange(tn, tm) && !visited[tn][tm] && map[tn][tm] == 1) {
                    visited[tn][tm] = true;
                    queue.add(new Position(tn, tm));
                }
            }
        }
    }

    public static boolean outOfRange(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= M;
    }
}
