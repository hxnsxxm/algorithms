package dp._1로만들기;

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
                new FileReader("baekjoon/dp/_1로만들기/s3_01463.txt")
        );

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        System.out.println(recursion(N));
        System.out.println(dp(N));
    }

    static int recursion(int n) {
        if (n == 1)
            return 0;

        if (n % 2 == 0)
            return Math.min(recursion(n/2), recursion(n - 1)) + 1;

        if (n % 3 == 0)
            return Math.min(recursion(n/3), recursion(n - 1)) + 1;

        if (n % 2 == 0 && n % 3 == 0) {
            return Math.min(recursion(n/3), recursion(n/2)) + 1;
        }

        return recursion(n - 1) + 1;
    }

    static int dp(int n) {
        int[] tab = new int[1000001];

        tab[2] = 1;
        tab[3] = 1;

        for (int i = 4; i <= n; i++) {

            if (n % 2 == 0 && n % 3 == 0)
                tab[i] = Math.min(tab[i/2], tab[i/3]) + 1;
            else if (n % 2 == 0)
                tab[i] = Math.min(tab[i/2], tab[i - 1]) + 1;
            else if (n % 3 == 0)
                tab[i] = Math.min(tab[i/3], tab[i - 1]) + 1;
            else
                tab[i] = tab[i - 1] + 1;
        }

        return tab[n];
    }

}
