import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g3_01520_내리막길 {

    static int N;
    static int M;
    static int[][] map;
    static int[][] memo;
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/g3_01520.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        memo = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }

        answer = dfs(1, 1);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int dfs(int n, int m) {
        if (n == N && m == M) {
            return 1;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        memo[n][m] = 0;
        for (int i = 0; i < 4; i++) {
            int tn = n + dn[i];
            int tm = m + dm[i];

            if (tn < 1 || tm < 1 || tn > N || tm > M) {
                continue;
            }

            if (map[n][m] > map[tn][tm]) {
                memo[n][m] += dfs(tn, tm);
            }
        }

        return memo[n][m];
    }
}
