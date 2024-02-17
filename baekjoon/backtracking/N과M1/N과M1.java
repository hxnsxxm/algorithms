package backtracking.N과M1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N과M1 {

    static int N;
    static int M;
    static StringBuffer sb = new StringBuffer();
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/backtracking/N과M1/s3_15649.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        used = new boolean[N];
        bt(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bt(int depth) {
        //Decision space
        //1. 길이가 M인 수열
        if (depth == M) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i + 1;
                bt(depth + 1);
                used[i] = false;
            }
        }

    }
}
