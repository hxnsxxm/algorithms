import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s5_02167_2차원배열의합 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("prefixsum/input/s5_02167.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K;
        int[][] inputs = new int[N][M];
        int[][] prefix = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            prefix[i][0] = 0;
        }
        for (int i = 0; i <= M; i++) {
            prefix[0][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + inputs[i][j];
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int m1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int m2 = Integer.parseInt(st.nextToken()) - 1;
            int result = prefix[n2 + 1][m2 + 1] - prefix[n2 + 1][m1] - prefix[n1][m2 + 1] + prefix[n1][m1];
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
