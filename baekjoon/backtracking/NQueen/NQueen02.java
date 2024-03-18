package NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NQueen02 {

    static int N;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/backtracking/NQueen/g4_09663.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        bt(1);
        System.out.println(result);
    }

    static void bt(int depth) {
        if (depth == N + 1) {
            result++;
            return ;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;

        }
    }
}
