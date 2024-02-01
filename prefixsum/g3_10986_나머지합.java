import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g3_10986_나머지합 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("prefixsum/input/g3_10986.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] prefix = new long[N + 1];
        long[] counts = new long[M];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = (prefix[i] + Integer.parseInt(st.nextToken())) % M;

            if (prefix[i + 1] == 0) {
                result++;
            }

            counts[(int)prefix[i + 1]]++;
        }

        for (int i = 0; i < M; i++) {
            if (counts[i] > 1) {
                result += (counts[i] * (counts[i] - 1) / 2);
            }
        }

//        int left = 0;
//        int right = 1;
//        int result = 0;
//
//        for (int i = 0; i < N; i++) {
//            for (int j = i + 1; j <= N; j++) {
//                long remainder = (prefix[j] - prefix[i]) % M;
//                if (remainder == 0) {
//                    result++;
//                }
//            }
//        }

//        while (left < N && right <= N) {
//            long quotient = (prefix[right] - prefix[left]) / M;
//            long remainder = (prefix[right] - prefix[left]) % M;
//
//            System.out.print("(" + left + ", " + right + ") " + quotient + ", " + remainder);
//
//            if (quotient == 0 && remainder == 0) {
//                System.out.println(" >> 0 0");
//                right++;
//            } else if (remainder == 0) {
//                System.out.println(" >> - 0");
//                result++;
//                right++;
//            } else {
//                if (quotient > 0) {
//                    System.out.println(" >> - -");
//                    left++;
//                } else {
//                    System.out.println(" >> 0 -");
//                    right++;
//                }
//            }
//        }

        System.out.print(result);
    }
}
