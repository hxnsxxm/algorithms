package 설탕배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 설탕배달 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/설탕배달/s4_02839.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int goal = Integer.parseInt(br.readLine());
        System.out.println(sugar(goal));
        System.out.println(sugar_bottom_up(goal));
    }

    static public int sugar(int n) {

        if (n == 0)
            return 0;

        if (n >= 5) {
            int cnt = sugar(n - 5);
            if (cnt != -1)
                return cnt + 1;
        }

        if (n >= 3) {
            int cnt = sugar(n - 3);
            if (cnt != -1)
                return cnt + 1;
        }

        return -1;
    }

    static public int sugar_bottom_up(int n) {
        if (n == 0)
            return 0;

        int[] tabular = new int[5001];

        for (int i = 1; i <= n; i++) {
            tabular[i] = -1;
        }
        tabular[3] = 1;
        tabular[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (tabular[i - 3] != -1 && tabular[i - 5] != -1)
                tabular[i] = Math.min(tabular[i - 3], tabular[i - 5]) + 1;
            else if (tabular[i - 5] != -1)
                tabular[i] = tabular[i - 5] + 1;
            else if (tabular[i - 3] != -1)
                tabular[i] = tabular[i - 3] + 1;
        }

        return tabular[n];
    }
}
