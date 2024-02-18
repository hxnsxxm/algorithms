package NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NQueen {

    static int N;
    static int result;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/backtracking/NQueen/g4_09663.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        queens = new int[N];

        bt(0);

        System.out.print(result);
    }

    static void bt(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queens[depth] = i;
            // 유효한 퀸만 놓고 다음 퀸 검사
            if (isValid(depth)) {
                bt(depth + 1);
            }
        }
    }

    static boolean isValid(int col) {
        // 1 ~ N-1 까지 유효성 검시
        for (int i = 0; i < col; i++) {
            if (queens[i] == queens[col]) {
                return false;
            } else if (Math.abs(i - col) == Math.abs(queens[i] - queens[col])) {
                return false;
            }
        }

        return true;
    }
}
