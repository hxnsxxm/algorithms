import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_15686_치킨배달 {

    static int N;
    static int M;
    static int[][] map;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static boolean[] visited;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("backtracking/input/g5_15686.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[chickens.size()];

        bt(0, 0);
        System.out.print(Min);
    }

    static void bt(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int[] house : houses) {
                int tmp = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (visited[i]) {
                        int[] chicken = chickens.get(i);
                        int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                        tmp = Math.min(tmp, distance);
                    }
                }
                sum += tmp;
            }
            Min = Math.min(Min, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
