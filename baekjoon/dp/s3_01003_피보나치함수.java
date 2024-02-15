import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_01003_피보나치함수 {

    static int[][] fibonacci;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s3_01003.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci = new int[41][2];

            fibonacci[0][0] = 1;
            fibonacci[0][1] = 0;
            fibonacci[1][0] = 0;
            fibonacci[1][1] = 1;

            for (int i = 2; i <= N; i++) {
                fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
                fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
            }

            sb.append(fibonacci[N][0]).append(" ").append(fibonacci[N][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
