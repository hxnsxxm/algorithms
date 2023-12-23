import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_04963_섬의개수 {

    static int W;
    static int H;
    static int[][] map;
    static boolean[][] visited;
    static int[] dh = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dw = {1, 1, 0, -1, -1, -1, 0, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s2_04963.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0)
                break;

            map = new int[H][W];
            visited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }

    }

    static void bfs(int h, int w) {
        Queue<int[]> queue = new LinkedList<>();

        visited[h][w] = true;
        queue.add(new int[]{h, w});
        count += 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 8; i++) {
                int th = pos[0] + dh[i];
                int tw = pos[1] + dw[i];
                if (!outOfRange(th, tw) && !visited[th][tw] && map[th][tw] == 1) {
                    visited[th][tw] = true;
                    queue.add(new int[]{th, tw});
                }
            }
        }
    }

    static boolean outOfRange(int h, int w) {
        return w < 0 || h < 0 || w >= W || h >= H;
    }
}
