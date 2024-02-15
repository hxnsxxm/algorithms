import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_11725_트리의부모찾기 {

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dfs/input/s2_11725.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            graph[source].add(destination);
            graph[destination].add(source);
        }

        //dfs(1, 1);
        bfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int parent, int vertex) {
        visited[vertex] = parent;

        for (int node : graph[vertex]) {
            if (visited[node] == 0) {
                dfs(vertex, node);
            }
        }
    }

    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int n : graph[node]) {
                if (visited[n] == 0) {
                    visited[n] = node;
                    queue.add(n);
                }
            }
        }
    }

}
