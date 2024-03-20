package dp.설탕배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class solve_3rd {

    static int N;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/설탕배달/s4_02839.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        System.out.println(recursive(N));
        System.out.println(dp(N));
    }

//    static int recursive(int n) {
//        if (n <= 2 || n == 4)
//            return 0;
//        if (n == 3 || n == 5)
//            return 1;
//
//        return recursive(n - 3) + recursive(n - 5);
//    }

    static int recursive(int n) {
        if (n == 0)
            return 0;

        if (n >= 5) {
            int cnt = recursive(n - 5);
            if (cnt != -1)
                return cnt + 1;
        }

        if (n >= 3) {
            int cnt = recursive(n - 3);
            if (cnt != -1)
                return cnt + 1;
        }

        return -1;
    }

    static int dp(int n) {
        int[] tab = new int[5001];

        for (int i = 0; i <= n; i++)
            tab[i] = -1;

        tab[3] = 1;
        tab[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (tab[i - 5] != -1 && tab[i - 3] != -1)
                tab[i] = Math.min(tab[i - 3], tab[i - 5]) + 1;
            else if (tab[i - 5] != -1)
                tab[i] = tab[i - 5] + 1;
            else if (tab[i - 3] != -1)
                tab[i] = tab[i - 3] + 1;
        }

        return tab[n];
    }

}
