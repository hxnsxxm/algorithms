import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class s3_12789_도키도키간식드리미 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("suji/input/s3_12789.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int seq = 1;
        int idx = 1;
        boolean flag = true;
        while (seq <= N) {
            int num = 0;
            int line = 0;
            if (idx <= N)
                num = nums[idx];
            if (!stack.isEmpty())
                line = stack.peek();

            if (num == seq) {
                idx++;
                seq++;
            } else if (line == seq) {
                stack.pop();
                seq++;
            } else {
                if (idx <= N) {
                    stack.add(num);
                    idx++;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.print("Nice");
        } else {
            System.out.print("Sad");
        }
    }
}
