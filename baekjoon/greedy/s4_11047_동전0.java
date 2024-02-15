import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collector;

public class s4_11047_동전0 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("greedy/input/s4_11047.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins, Collections.reverseOrder());

        int balance = K;

        for (int coin : coins) {
            int plusCoin = balance / coin;
            if (plusCoin > 0) {
                balance -= plusCoin*coin;
                result += plusCoin;
            }
        }

        System.out.print(result);
    }
}
