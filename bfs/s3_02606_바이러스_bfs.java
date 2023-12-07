import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s3_02606_바이러스_bfs {

    static int N;
    static int K;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s3_02606.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int answer = 0;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            graph[source].add(destination);
            graph[destination].add(source);
        }

        answer = bfs(1);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int bfs(int vertex) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int n : graph[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    cnt += 1;
                    queue.add(n);
                }
            }
        }

        return cnt;
    }
}
