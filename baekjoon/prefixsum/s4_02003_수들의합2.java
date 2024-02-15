import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s4_02003_수들의합2 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("prefixsum/input/s4_02003.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] inputs = new int[N];
        int[] prefix = new int[N + 1];
        int result = 0;

        prefix[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            prefix[i + 1] = prefix[i] + inputs[i];
        }

        int left = 1;
        int right = 1;
        while (left <= right) {
            int sum = prefix[right] - prefix[left - 1];

            if (sum < M) {
                right++;
            } else if (sum > M) {
                if (left == right)
                    right++;
                else
                    left++;
            } else if (sum == M) {
                result++;
                right++;
            }

            if (right > N || left > N)
                break;
        }

        System.out.print(result);
    }
}
