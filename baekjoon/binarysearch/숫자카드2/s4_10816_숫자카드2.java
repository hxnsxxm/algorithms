package 숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_10816_숫자카드2 {

    static int N;
    static int M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("binarysearch/input/s4_10816.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(bs(num)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static int bs(int n) {
        int goal = n;
        int start = 0;
        int end = N - 1;
        int count = 0;

        while (start <= end) {
            int mid = (start + end)/2;
            int num = nums[mid];

            if (goal == num) {
                count++;
                int tmp = mid;
                while (tmp > 0 && goal == nums[tmp - 1]) {
                    count++;
                    tmp -= 1;
                }
                tmp = mid;
                while (tmp < N - 1 && goal == nums[tmp + 1]) {
                    count++;
                    tmp += 1;
                }
                return count;
            } else if (goal < num) {
                end = mid - 1;
            } else if (goal > num) {
                start = mid + 1;
            }
        }

        return 0;
    }
}
