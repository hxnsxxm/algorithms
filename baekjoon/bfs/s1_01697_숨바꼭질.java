import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_01697_숨바꼭질 {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s1_01697.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int answer = 0;

        answer = bfs();
        System.out.println(answer - 1);
    }

    public static int bfs() {
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();

        visited[N] = 1;
        queue.add(N);

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int tmp;

            tmp = pos - 1;
            if (!outOfRange(tmp) && visited[tmp] == 0) {
                visited[tmp] = visited[pos] + 1;
                queue.add(tmp);
                if (tmp == K) return visited[tmp];
            }

            tmp = pos + 1;
            if (!outOfRange(tmp) && visited[tmp] == 0) {
                visited[tmp] = visited[pos] + 1;
                queue.add(tmp);
                if (tmp == K) return visited[tmp];
            }

            tmp = pos * 2;
            if (!outOfRange(tmp) && visited[tmp] == 0) {
                visited[tmp] = visited[pos] + 1;
                queue.add(tmp);
                if (tmp == K) return visited[tmp];
            }
        }
        return visited[K];
    }

    public static boolean outOfRange(int p) {
        return p < 0 || p > 100000;
    }
}
