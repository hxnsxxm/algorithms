import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_07576_토마토 {

    static int N;
    static int M;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/g5_07576.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int answer = 0;
        boolean flag = false;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    flag = true;
                } else {
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(answer - 1);
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tn = pos[0] + dn[i];
                int tm = pos[1] + dm[i];

                if (!outOfRange(tn, tm) && map[tn][tm] == 0) {
                    queue.add(new int[]{tn, tm});
                    map[tn][tm] = map[pos[0]][pos[1]] + 1;
                }
            }
        }
    }

    public static boolean outOfRange(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= M;
    }
}
