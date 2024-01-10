import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_01920_수찾기 {

    static int N;
    static int M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("binarysearch/input/s4_01920.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

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
            int m = Integer.parseInt(st.nextToken());
            System.out.println(bs(m));
        }
    }

    static int bs(int n) {
        int goal = n;
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (end + start)/2;
            int num = nums[mid];

            if (goal == num)
                return 1;
            else if (goal < num) {
                end = mid - 1;
            } else if (goal > num) {
                start = mid + 1;
            }
        }
        return 0;
    }
}
