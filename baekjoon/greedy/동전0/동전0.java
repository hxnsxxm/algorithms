package 동전0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 동전0 {

    static int N;
    static int K;
    static Integer[] coins;
    static int result;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/동전0/s4_11047.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, new Comparator<Integer>(){
            @Override
            public int compare(Integer n, Integer m) {
                return m - n;
            }
        });

        //System.out.println(Arrays.toString(coins));

        for (int i = 0; i < N; i++) {
            result += K/coins[i];
            //System.out.println(coins[i] + " : " + result + ", " + K%coins[i]);
            K %= coins[i];
        }

        System.out.print(result);
    }
}
