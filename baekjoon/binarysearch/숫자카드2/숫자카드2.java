package 숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {

    static int N;
    static int M;
    static int[] nums;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/binarysearch/숫자카드2/s4_10816.txt")
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
        //System.out.println(Arrays.toString(nums));

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            bSearch(m);
            //System.out.println("m : " + m + " >> " + upperBoundSBearch(m) + ", " + underBoundBSearch(m));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static int lower_bound(int goal) {
        int left = 0;
        int right = nums.length;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            int num = nums[mid];

            if (num < goal)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static int upper_bound(int goal) {
        int left = 0;
        int right = nums.length;
        int mid = 0;

        while (left < right) {
            mid = (left + right)/2;
            int num = nums[mid];

            if (num <= goal) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // 시간초과
    // while 문으로 검색할 시 최대 O(N)
    public static void bSearch(int goal) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int cnt = 0;

        while (left <= right) {
            mid = (left + right)/2;
            int num = nums[mid];

            if (num == goal) {
                sb.append(upper_bound(goal) - lower_bound(goal)).append(" ");
                return;
            } else if (num < goal) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        sb.append(cnt).append(" ");
    }
}
