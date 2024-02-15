package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_02178_미로탐색 {

    static int N;
    static int M;
    static int[][] map;
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("resolve/silver/input/미로탐색.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        map[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tn = pos[0] + dn[i];
                int tm = pos[1] + dm[i];

                if (!outOfRange(tn, tm) && map[tn][tm] == 1) {
                    queue.add(new int[]{tn, tm});
                    map[tn][tm] = map[pos[0]][pos[1]] + 1;
                }
            }
        }
    }

    static boolean outOfRange(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= M;
    }
}
