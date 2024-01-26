import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s1_14888_연산자끼워넣기 {

    static int N;
    static int[] nums;
    static int[] op;
    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("backtracking/input/s1_14888.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        min = 1000000000;
        max = -1000000000;

        bt(0, nums[0]);
        System.out.print(max + "\n" + min);
    }

    static void bt(int depth, int num) {
        if (depth == N - 1) {
            min = Math.min(num, min);
            max = Math.max(num, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:
                        bt(depth + 1, num + nums[depth + 1]);
                        break;
                    case 1:
                        bt(depth + 1, num - nums[depth + 1]);
                        break;
                    case 2:
                        bt(depth + 1, num * nums[depth + 1]);
                        break;
                    case 3:
                        bt(depth + 1, num / nums[depth + 1]);
                        break;
                }
                op[i]++;
            }
        }
    }
}
