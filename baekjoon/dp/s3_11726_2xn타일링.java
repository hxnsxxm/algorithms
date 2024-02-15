import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_11726_2xn타일링 {

    static int N;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s3_11726.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] tabular = new int[1000 + 1];
        tabular[1] = 1;
        tabular[2] = 2;

        for (int i = 3; i <= N; i++) {
            tabular[i] = (tabular[i - 1] + tabular[i - 2]) % 10007;
        }

        System.out.println(tabular[N]);
    }
}
