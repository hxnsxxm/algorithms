import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class g5_12865_평범한배낭 {

    static int N;
    static int K;
    static int[][] jew;
    static Integer[][] memo;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/g5_12865.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jew = new int[N + 1][2];
        memo = new Integer[N + 1][K + 1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jew[i][0] = W;
            jew[i][1] = V;
        }

        //result = knapsack_topDown(N, K);
        //result = knapsack_bottomUp();
        result = knapsack_bottomUpV2();
        System.out.print(result);
    }

    /* Top-Down */
    static int knapsack_topDown(int i, int k) {
        //i가 0미만, 즉 범위 밖이 된다면
        if (i < 0)
            return 0;

        //탐색하지 않은 위치라면
        if (memo[i][k] == null) {
            //현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
            if (jew[i][0] > k) {
                memo[i][k] = knapsack_topDown(i - 1, k);
            }
            //현재 물건(i)을 담을 수 있는 경우
            else if (jew[i][0] <= k) {
                //이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i]) 중 큰 값을 저장
                memo[i][k] = Math.max(knapsack_topDown(i - 1, k), knapsack_topDown(i - 1, k - jew[i][0]) + jew[i][1]);
            }
        }

        return memo[i][k];
    }

    /* Bottom-Up v1 */
    static int knapsack_bottomUp() {
        int[][] tabular = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (jew[i][0] > j) {
                    tabular[i][j] = tabular[i - 1][j];
                } else {
                    tabular[i][j] = Math.max(tabular[i - 1][j], tabular[i - 1][j - jew[i][0]] + jew[i][1]);
                }
            }
        }

        return tabular[N][K];
    }

    /* Bottom-Up v2 */
    static int knapsack_bottomUpV2() {
        int[] tabular = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            //k부터 탐색하여 담을 수 있는 무게 함계치가 넘지 않을 때까지 반복
            for (int j = K; j - jew[i][0] >= 0; j--) {
                tabular[j] = Math.max(tabular[j], tabular[j - jew[i][0]] + jew[i][1]);
            }
        }

        return tabular[K];
    }
}
