import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_02579_계단오르기 {

    static int N;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s3_02579.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stairs = new int[301];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(dp_bottomUp());
    }

    static int dp_bottomUp() {
        int[] tabular = new int[301];

        tabular[1] = stairs[1];
        tabular[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= N; i++) {
            tabular[i] = Math.max(tabular[i - 2], tabular[i - 3] + stairs[i - 1]) + stairs[i];
        }

        return tabular[N];
    }
}
