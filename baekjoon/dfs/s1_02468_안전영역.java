import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s1_02468_안전영역 {

    static int N;
    static int[][] map;
    static int min;
    static int max;
    static boolean[][] visited;
    static int answer;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("hansaem/algorithms/dfs/input/s1_02468.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        answer = 0;
        for (int h = min; h <= max; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (map[i][j] > h) {
                        count += 1;
                        dfs(i, j, h);
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c, int h) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];
            if (!outOfRange(tr, tc) && !visited[tr][tc] && map[tr][tc] > h) {
                dfs(tr, tc, h);
            }
        }
    }

    public static boolean outOfRange(int r, int c) {
        return r < 0 || c < 0 || c >= N || r >= N;
    }
}
