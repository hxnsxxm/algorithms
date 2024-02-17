package _2xn타일링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2xn타일링 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/_2xn타일링/s3_11726.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        //System.out.println(count(n));
        System.out.print(count_bottom_up(n));
    }

    static int count(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return (count(n - 1) + count(n - 2)) % 10007;
    }

    static int count_bottom_up(int n) {
        int[] tabular = new int[1001];

        tabular[1] = 1;
        tabular[2] = 2;

        for (int i = 3; i <= n; i++) {
            tabular[i] = (tabular[i - 1] + tabular[i - 2]) % 10007;
        }

        return tabular[n];
    }
}
