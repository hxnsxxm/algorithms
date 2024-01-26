import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_01182_부분수열의합 {

    static int N;
    static int S;
    static int[] inputs;
    static int result;
    static int count;
    static int limit;
    static Integer[] nums;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("backtracking/input/s2_01182.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        nums = new Integer[N];
        limit = (int)Math.pow(2, N);
        bt(0, 0);
        System.out.println(result);
    }

    static void bt(int depth, int num) {
        if (depth == N) {
            count++;
            if (count == limit)
                return;
            System.out.println(num + " :: " + Arrays.toString(nums));
            if (num == S)
                result++;
            return;
        }

        int n = inputs[depth];
        nums[depth] = n;
        bt(depth + 1, num + n);
        nums[depth] = 100000;
        bt(depth + 1, num);
    }
}
