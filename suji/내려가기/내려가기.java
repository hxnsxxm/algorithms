package 내려가기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내려가기 {

    private static int N;
    private static int[][] nums;
    private static int[][] minDp;
    private static int[][] maxDp;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("suji/내려가기/input.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N][3];
        minDp = new int[N][3];
        maxDp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }

        //최소 minDp
        minDp[N - 1][0] = nums[N - 1][0];
        minDp[N - 1][1] = nums[N - 1][1];
        minDp[N - 1][2] = nums[N - 1][2];
        for (int i = N - 1; i > 0; i--) {
            minDp[i - 1][0] = nums[i - 1][0] + Math.min(minDp[i][0], minDp[i][1]);
            minDp[i - 1][1] = nums[i - 1][1] + Math.min(minDp[i][0], Math.min(minDp[i][1], minDp[i][2]));
            minDp[i - 1][2] = nums[i - 1][2] + Math.min(minDp[i][1], minDp[i][2]);
        }

        //최대 maxDp
        maxDp[N - 1][0] = nums[N - 1][0];
        maxDp[N - 1][1] = nums[N - 1][1];
        maxDp[N - 1][2] = nums[N - 1][2];
        for (int i = N - 1; i > 0; i--) {
            maxDp[i - 1][0] = nums[i - 1][0] + Math.max(maxDp[i][0], maxDp[i][1]);
            maxDp[i - 1][1] = nums[i - 1][1] + Math.max(maxDp[i][0], Math.max(maxDp[i][1], maxDp[i][2]));
            maxDp[i - 1][2] = nums[i - 1][2] + Math.max(maxDp[i][1], maxDp[i][2]);
        }

        System.out.print(Math.max(maxDp[0][0], Math.max(maxDp[0][1], maxDp[0][2])) + " ");
        System.out.println(Math.min(minDp[0][0], Math.min(minDp[0][1], minDp[0][2])));

    }
}
