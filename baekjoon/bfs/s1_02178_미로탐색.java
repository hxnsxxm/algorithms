import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_02178_미로탐색 {

    static int N; // 0 ~ N - 1
    static int M; // 0 ~ M - 1
    static char[][] map;
    static int[][] depth;
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s1_02178.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        depth = new int[N][M];
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs(0, 0);

        System.out.println(depth[N-1][M-1]);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(depth[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int n, int m) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{n, m});
        visited[n][m] = true;
        depth[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tn = pos[0] + dn[i];
                int tm = pos[1] + dm[i];

                if (!outOfRange(tn, tm) && !visited[tn][tm] && map[tn][tm] == '1') {
                    visited[tn][tm] = true;
                    queue.add(new int[]{tn, tm});
                    depth[tn][tm] = depth[pos[0]][pos[1]] + 1;
                }
                if (tn == N - 1 && tm == M - 1) return;
            }
        }
    }

    public static boolean outOfRange(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= M;
    }
}
