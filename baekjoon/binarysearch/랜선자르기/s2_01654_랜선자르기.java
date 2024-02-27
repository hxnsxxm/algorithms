package binarysearch.랜선자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s2_01654_랜선자르기 {

    static int K;
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("binarysearch/랜선자르기/s2_01654.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long max = 0;
        long min = 0;

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        nums = new int[K];
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(nums[i], max);
        }
        max += 1;

        while (min < max) {
            long mid = (min + max)/2;
            long count = 0;
            for (int num : nums) {
                count += num/mid;
            }

            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
