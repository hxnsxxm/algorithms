import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class s1_02583_영역구하기 {

    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dm = {0, -1, 0, 1};
    static int[] dn = {1, 0, -1, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dfs/input/s1_02583.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            for (int m = m1 + 1; m <= m2; m++) {
                for (int n = n1 + 1; n <= n2; n++) {
                    map[m][n] = 1;
                }
            }
        }

        for (int m = 1; m <= M; m++) {
            for (int n = 1; n <= N; n++) {
                if (!visited[m][n] && map[m][n] == 0) {
                    count = 0;
                    dfs(m, n);
                    list.add(count);
                }
            }
        }
        sb.append(list.size()).append("\n");
        Collections.sort(list);

        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int m, int n) {
        visited[m][n] = true;

        count += 1;

        for (int i = 0; i < 4; i++) {
            int tm = m + dm[i];
            int tn = n + dn[i];
            if (!outOfRange(tm, tn) && !visited[tm][tn] && map[tm][tn] == 0) {
                dfs(tm, tn);
            }
        }
    }

    static boolean outOfRange(int m, int n) {
        return n <= 0 || m <= 0 || n > N || m > M;
    }

}
