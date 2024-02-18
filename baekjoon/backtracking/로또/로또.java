package backtracking.로또;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또 {

    static int[] nums;
    static int limit = 6;
    static StringBuffer sb = new StringBuffer();
    static int len;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/backtracking/로또/6603.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            len = Integer.parseInt(st.nextToken());
            if (len == 0) {
                break;
            }
            nums = new int[len];
            used = new boolean[len];
            int[] lotto = new int[6];

            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);

            bt(0, 0, lotto);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bt(int depth, int start, int[] lotto) {
        if (depth == limit) {
            for (int n : lotto) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < len; i++) {
            lotto[depth] = nums[i];
            bt(depth + 1, i + 1, lotto);
        }
    }
}
