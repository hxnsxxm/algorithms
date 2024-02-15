import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s2_01012_유기농배추 {

    static int[][] map;
    static int T;
    static int M;
    static int N;
    static int K;
    static int[] dm = {1, 0, -1, 0};
    static int[] dn = {0, 1, 0, -1};
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("hansaem/algorithms/dfs/input/s2_01012.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            answer = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                map[n][m] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j])
                        continue;
                    if (map[i][j] == 1) {
                        answer += 1;
                        dfs(i, j);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void dfs(int n, int m) {
        visited[n][m] = true;

        for (int i = 0; i < 4; i++) {
            int tn = n + dn[i];
            int tm = m + dm[i];
            if (!outOfRange(tn, tm) && map[tn][tm] == 1 && !visited[tn][tm]) {
                dfs(tn, tm);
            }
        }
    }

    public static boolean outOfRange(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= M;
    }

}
