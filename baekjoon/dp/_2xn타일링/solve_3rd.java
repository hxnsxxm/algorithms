package dp._2xn타일링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class solve_3rd {

    static int n;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/_2xn타일링/s3_11726.txt")
        );

        n = Integer.parseInt(br.readLine());
        System.out.println(recursion(n));
    }

    static int recursion(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return (recursion(n - 2) + recursion(n - 1)) % 10007;
    }

    static int dp(int n) {
        int[] tab = new int[1001];

        tab[1] = 1;
        tab[2] = 2;

        for (int i = 3; i <= n; i++) {
            tab[i] = (tab[i - 2] + tab[i - 1])%10007;
        }

        return tab[n];
    }
}
