import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class s4_02217_로프 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("greedy/input/s4_02217.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums, Collections.reverseOrder());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]*(i+1));
        }

        System.out.print(max);
    }
}
