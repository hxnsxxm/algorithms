package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS_11724_알파벳 {

    static char[][] keyboard;
    static int visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int R;
    static int C;
    static int result;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("resolve/gold/input/알파벳.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        keyboard = new char[R][C];
        for (int i = 0; i < R; i++) {
            keyboard[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(result);
    }

    static void dfs(int r, int c, int cnt) {
        int bitMask = 1 << (keyboard[r][c] - 'A');
        visited |= bitMask;
//        System.out.println("(" + r + ", " + c + ") " + keyboard[r][c] + " / " + cnt);

        result = Math.max(cnt, result);

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];

            if (!outOfRange(tr, tc)) {
                int nextBit = 1 << (keyboard[tr][tc] - 'A');
                if ((visited & nextBit) == 0) {
//                    visited |= nextBit;
                    dfs(tr, tc, cnt + 1);
//                    visited &= ~nextBit;

                }
            }
        }

        visited &= ~bitMask;

    }

    static boolean outOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= R || c >= C;
    }
}
