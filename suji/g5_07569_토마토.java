import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_07569_토마토 {
    //  단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100
    static int M; //가로
    static int N; //세로
    static int H; //높이
    static int[][][] map; //상자
    static int[] dm = {1, 0, -1, 0, 0, 0}; // 오른쪽 앞 왼쪽 뒤 아래 위
    static int[] dn = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int second;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("suji/input/g5_07569.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken()); //0: 가장 아래, H - 1: 가장 위
        map = new int[H][N][M];
        Queue<Position> queue = new LinkedList<>();
        second = 0;
        boolean flag = false;

        for (int i = 0; i < H * N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for (int j = 0; j < size; j++) {
                int th = i / N;
                int tn = i % N;
                int tm = j;
                map[th][tn][tm] = Integer.parseInt(st.nextToken());
                if (map[th][tn][tm] == 1) {
                    queue.add(new Position(tm, tn, th));
                }
            }
        }

        bfs(queue);

        for (int i = 0; i < H * N; i++) {
            for (int j = 0; j < M; j++) {
                int th = i / N;
                int tn = i % N;
                int tm = j;
                if (map[th][tn][tm] == 0)
                    flag = true;
            }
        }

        if (flag)
            sb.append("-1");
        else
            sb.append(second + "");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bfs(Queue<Position> queue) {
        Queue<Position> q = new LinkedList<>();

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (int i = 0; i < 6; i++) {
                int tm = pos.getM() + dm[i];
                int tn = pos.getN() + dn[i];
                int th = pos.getH() + dh[i];
                if (!outOfRange(tm, tn, th) && map[th][tn][tm] == 0) {

                    map[th][tn][tm] = 1;
                    q.add(new Position(tm, tn, th));
                }
            }
        }

        if (!q.isEmpty()) {
            second += 1;
            bfs(q);
        }
    }

    static class Position {
        int m;
        int n;
        int h;
        public Position (int m, int n, int h) {
            this.m = m;
            this.n = n;
            this.h = h;
        }
        public int getM() { return m; }
        public int getN() { return n; }
        public int getH() { return h; }
    }

    static boolean outOfRange(int m, int n, int h) {
        return m < 0 || n < 0 || h < 0 || m >= M || n >= N || h >= H;
    }
}
