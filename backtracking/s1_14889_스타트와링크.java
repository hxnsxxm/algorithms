import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_14889_스타트와링크 {

    static int N;
    static int[][] synergy;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("backtracking/input/s1_14889.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        synergy = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0, 0);
        System.out.print(min);
    }

    static void bt(int depth, int row) {
        if (depth == N/2) {
            diff();
            return;
        }

        for (int i = row; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    teamStart += synergy[i][j];
                    teamStart += synergy[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    teamLink += synergy[i][j];
                    teamLink += synergy[j][i];
                }
            }
        }

        int val = Math.abs(teamStart - teamLink);

        min = Math.min(val, min);
    }
}
