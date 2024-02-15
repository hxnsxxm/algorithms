import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_01463_1로만들기 {

    static int X;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s3_01463.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        X = Integer.parseInt(br.readLine());
        memo = new int[X + 1];

        //int answer = dp_bottomUp(X);
        int answer = dp_topDown(X);

        System.out.println(answer);
    }

    static int dp_bottomUp(int x) {
        int[] tabular = new int[1000001];

        tabular[1] = 0;
        tabular[2] = 1;
        tabular[3] = 1;
        tabular[4] = 2;

        for (int i = 5; i <= X; i++) {
            if (i % 3 == 0) {
                tabular[i] = Math.min(tabular[i/3], tabular[i - 1]) + 1;
            }
            if (i % 2 == 0) {
                tabular[i] = Math.min(tabular[i/2], tabular[i - 1]) + 1;
            }
            if (i % 3 == 0 && i % 2 == 0) {
                tabular[i] = Math.min(tabular[i/3], tabular[i/2]) + 1;
            }
            if (i % 3 != 0 && i % 2 != 0) {
                tabular[i] = tabular[i - 1] + 1;
            }
        }

        return tabular[X];
    }

    static int dp_topDown(int x) {
        if (x == 1)
            return 0;
        if (memo[x] != 0)
            return memo[x];

        if (x % 6 == 0)
            memo[x] = Math.min(dp_topDown(x/3), dp_topDown(x/2)) + 1;
        else if (x % 3 == 0)
            memo[x] = Math.min(dp_topDown(x/3), dp_topDown(x - 1)) + 1;
        else if (x % 2 == 0)
            memo[x] = Math.min(dp_topDown(x/2), dp_topDown(x - 1)) + 1;
        else
            memo[x] = dp_topDown(x - 1) + 1;

        return memo[x];
    }
}
