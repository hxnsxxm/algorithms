import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s1_01149_RGB거리 {

    static int N;
    static int[] R;
    static int[] G;
    static int[] B;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s1_01149.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        R = new int[N + 1];
        G = new int[N + 1];
        B = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(dp_bottomUp());

    }

    private static int dp_bottomUp() {
        int[] dpR = new int[N + 1];
        int[] dpG = new int[N + 1];
        int[] dpB = new int[N + 1];

        dpR[1] = R[1];
        dpG[1] = G[1];
        dpB[1] = B[1];

        for (int i = 2; i <= N; i++) {
            dpR[i] = R[i] + Math.min(dpG[i - 1], dpB[i - 1]);
            dpG[i] = G[i] + Math.min(dpR[i - 1], dpB[i - 1]);
            dpB[i] = B[i] + Math.min(dpR[i - 1], dpG[i - 1]);
        }

        return Math.min(dpR[N], Math.min(dpG[N], dpB[N]));
    }
}
