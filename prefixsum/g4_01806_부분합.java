import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g4_01806_부분합 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("prefixsum/input/g4_01806.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] input = new int[N];
        int[] prefix = new int[N + 1];
        prefix[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            prefix[i + 1] = prefix[i] + input[i];
        }

        int s = 1;
        int e = 1;
        int min = Integer.MAX_VALUE;
        boolean flag = true;
        while (s <= e) {
            int sum = prefix[e] - prefix[s - 1];
            if (sum < M) {
                e++;
            } else {
                min = Math.min(min, e - s + 1);
                s++;
                flag = false;
            }
            if (s > N || e > N)
                break;
        }

        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
