package _1로만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1로만들기 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/_1로만들기/s3_01463.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int X = Integer.parseInt(br.readLine());

        //System.out.print(operate(X));
        System.out.println(operate_bottom_up(X));
    }

    static int operate(int x) {
        if (x == 1)
            return 0;

        if (x%3 == 0) {
            return Math.min(operate(x/3), operate(x - 1)) + 1;
        }

        if (x%2 == 0) {
            return Math.min(operate(x/2), operate(x - 1)) + 1;
        }

        if (x%3 == 0 && x%2 == 0)
            return Math.min(operate(x/2), operate(x/3)) + 1;

        return operate(x - 1) + 1;
    }

    static int operate_bottom_up(int x) {
        if (x == 1)
            return 0;

        int[] tabular = new int[x + 1];
        tabular[1] = 0;
        if (x >= 2) tabular[2] = 1;
        if (x >= 3) tabular[3] = 1;

        for (int i = 4; i <= x; i++) {
            if (i%3 == 0)
                tabular[i] = Math.min(tabular[i/3], tabular[i - 1]) + 1;
            if (i%2 == 0)
                tabular[i] = Math.min(tabular[i/2], tabular[i - 1]) + 1;
            if (i % 3 == 0 && i % 2 == 0)
                tabular[i] = Math.min(tabular[i/3], tabular[i/2]) + 1;
            if (i % 3 != 0 && i % 2 != 0)
                tabular[i] = tabular[i - 1] + 1;
        }

        return tabular[x];
    }
}
