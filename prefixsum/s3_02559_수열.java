import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s3_02559_수열 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("prefixsum/input/s3_02559.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int[] prefix = new int[N + 1];
        prefix[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + Integer.parseInt(st.nextToken());
            if (i >= K - 1) {
                //System.out.println(prefix[i + 1] - prefix[i - K + 1]);
                max = Math.max(max, prefix[i + 1] - prefix[i - K + 1]);
            }
        }

        System.out.print(max);
    }
}
