import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_09095_123더하기 {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s3_09095.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int answer;

            memo = new int[11];
            //answer = dp_topDown(N);
            answer = dp_bottomUp(N);

            System.out.println(answer);
        }
    }

    static int dp_topDown(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (memo[n] != 0)
            return memo[n];

        return memo[n] = dp_topDown(n - 1) + dp_topDown(n - 2) + dp_topDown(n - 3);
    }

    static int dp_bottomUp(int n) {
        int[] tabular = new int[11];

        tabular[1] = 1;
        tabular[2] = 2;
        tabular[3] = 4;

        for (int i = 4; i < 11; i++) {
            tabular[i] = tabular[i - 1] + tabular[i - 2] + tabular[i - 3];
        }

        return tabular[n];
    }

}
