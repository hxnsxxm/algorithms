package 설탕배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s4_02839_설탕배달 {

    static int N;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s4_02839.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int answer;
        memo = new int[N + 1];

        //answer = dp_topDown(N);
        answer = dp_bottomUp();

        if (answer > 5000 || answer == 0) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    static int dp_topDown(int x) {
        if (x < 0)
            return 99998;
        if (x == 3 || x == 5)
            return 1;

        if (memo[x] != 0)
            return memo[x];

        return memo[x] = Math.min(dp_topDown(x - 3) + 1, dp_topDown(x - 5) + 1);
    }

    static int dp_bottomUp() {
        int[] tabular = new int[N + 1];

        tabular[3] = 1;
        if (N >= 5) tabular[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (tabular[i - 3] != 0)
                tabular[i] = tabular[i - 3] + 1;
            if (tabular[i - 5] != 0)
                tabular[i] = tabular[i - 5] + 1;
            if (tabular[i - 3] != 0 && tabular[i - 5] != 0)
                tabular[i] = Math.min(tabular[i - 3] + 1, tabular[i - 5] + 1);
        }

        return tabular[N];
    }
}

