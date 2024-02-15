import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class s2_01260_DFS와BFS_bfs {

    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 탐색을 시작할 정점의 번호
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("bfs/input/s2_01260.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            graph[source].add(destination);
            graph[destination].add(source);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(V);
    }

    public static void bfs(int vertex) {
        boolean[] visited = new boolean[N + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " > ");

            for (int n : graph[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
