package 서강그라운드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서강그라운드 {

    private static int n; //지역 개수
    private static int m; //예은이의 수색 범위
    private static int r; //길의 개수
    private static int[] items;
    private static int[][] map;
    private static final int INF = 1000000000;
    private static int max;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("suji/서강그라운드/input.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[n][n];
        for (int[] t : map)
            Arrays.fill(t, INF);
        for (int i = 0; i < n; i++)
            map[i][i] = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int area1 = Integer.parseInt(st.nextToken());
            int area2 = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            map[area1 - 1][area2 - 1] = num;
            map[area2 - 1][area1 - 1] = num;
        }

//        for (int[] m : map)
//            System.out.println(Arrays.toString(m));

        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][p] + map[p][j]);
                }
            }
        }

//        for (int[] m : map)
//            System.out.println(Arrays.toString(m));
//        System.out.println("-----");
//        System.out.println(Arrays.toString(items));

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= m)
                    cnt += items[j];
            }
//            System.out.println("cnt: " + cnt);
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
