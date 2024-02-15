package 연구소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 벽 3개를 임의로 세운다.
 *   1-1. 3중 반복문
 * 2. 바이러스를 퍼뜨린다.
 * 3. 나머지 안전 공간을 확인하여 최댓값을 저장한다.
 */
public class 연구소 {

    static int N; // map 세로 크기
    static int M; // map 가로 크기
    static int[][] map; // 연구소 map
    static int[][] tmp;
    static int result;
    static List<int[]> list = new ArrayList<>();
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/bfs/연구소/연구소.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
            }
        }

        // 1. 벽 3개 세우기
        for (int i = 0; i < N*M - 2; i++) {
            if (map[i/M][i%M] != 0)
                continue;
            map[i/M][i%M] = 1;
            for (int j = i + 1; j < N*M - 1; j++) {
                if (map[j/M][j%M] != 0)
                    continue;
                map[j/M][j%M] = 1;
                for (int k = j + 1; k < N*M; k++) {
                    if (map[k/M][k%M] != 0)
                        continue;
                    map[k/M][k%M] = 1;

                    copyMap();
                    bfs();
                    result = Math.max(result, countSafe());

                    map[k/M][k%M] = 0;
                }
                map[j/M][j%M] = 0;
            }
            map[i/M][i%M] = 0;
        }

        System.out.print(result);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int[] l : list) {
            queue.add(new int[]{l[0], l[1]});
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tn = pos[0] + dn[i];
                int tm = pos[1] + dm[i];
                if (!outOfRange(tn, tm) && tmp[tn][tm] == 0) {
                    tmp[tn][tm] = 2;
                    queue.add(new int[]{tn, tm});
                }
            }
        }
    }

    static boolean outOfRange(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= M;
    }

    static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
    }

    static int countSafe() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
