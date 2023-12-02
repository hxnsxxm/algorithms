import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class s1_02667_단지번호붙이기 {

    static int[][] map;
    static int N;
    static int total;
    static int cnt;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("hansaem/algorithms/dfs/input/s1_02667.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] tmp = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    continue;

                if (map[i][j] == 1) {
                    total += 1;
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        sb.append(total);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append("\n").append(list.get(i));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt += 1;

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];
            if (!outOfRange(tr, tc) && map[tr][tc] == 1 && !visited[tr][tc]) {
                dfs(tr, tc);
            }
        }
    }

    public static boolean outOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }
}
