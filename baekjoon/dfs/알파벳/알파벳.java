package 알파벳;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳 {

    static int R;
    static int C;
    static char[][] keys;
    static int visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dfs/알파벳/g4_01987.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        keys = new char[R][C];

        for (int i = 0; i < R; i++) {
            keys[i] = br.readLine().toCharArray();
        }

//        for (char[] k : keys) {
//            System.out.println(new String(k));
//        }

        //System.out.println("char: " + keys[0][0]);

        dfs(0, 0, 1);

        System.out.println(result);
    }

    static void dfs(int r, int c, int cnt) {
        visited |= (1 << (keys[r][c] - 'A'));
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];

            if (tr < 0 || tc < 0 || tr >= R || tc >= C)
                continue;
            int nextBit = (1 << (keys[tr][tc] - 'A'));
            if ((visited & nextBit) != 0)
                continue;

            //visited |= nextBit;
            dfs(tr, tc, cnt + 1);
            visited &= ~nextBit;
        }
    }

//    public static void dfs(int r, int c, int cnt) {
//        int bitMask = (1 << (keyboard[r][c] - 'A'));
//        visited |= bitMask;
//
//        answer = Math.max(answer, cnt);
//
//        for (int i = 0; i < 4; i++) {
//            int tr = r + dr[i];
//            int tc = c + dc[i];
//            if (!outOfRange(tr, tc)) {
//                int nextBit = (1 << (keyboard[tr][tc] - 'A'));
//                if ((visited & nextBit) == 0) {
//                    visited |= nextBit;
//                    dfs(tr, tc, cnt + 1);
//                    visited &= ~nextBit;
//                }
//            }
//        }
//    }
}
