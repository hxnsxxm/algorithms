package binarysearch.숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve_3rd {

    static int N;
    static int[] nums;
    static int M;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/binarysearch/숫자카드2/s4_10816.txt")
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
            sb.append(bs(Integer.parseInt(st.nextToken()))).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static int bs(int target) {
        return upper(target) - lower(target);
    }

    static int upper(int target) {
        int left = 0;
        int right = nums.length;// + 1;

        while (left < right) {
            int mid = left + (right - left)/2;
            int num = nums[mid];

            if (num <= target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    static int lower(int target) {
        int left = 0;
        int right = nums.length;// + 1;

        while (left < right) {
            int mid = left + (right - left)/2;
            int num = nums[mid];

            if (num < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
