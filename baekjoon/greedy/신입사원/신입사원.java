package greedy.신입사원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 신입사원 {

    static int T;
    static int N;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/신입사원/s1_01946.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            scores = new int[N + 1];

            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                scores[first] = second;
            }

            int min = scores[1];
            int result = N;
            for (int i = 2; i <= N; i++) {
                if (min < scores[i]) {
                    result--;
                } else if (min > scores[i]) {
                    min = scores[i];
                }
            }

            System.out.println(result);
        }
    }
}
