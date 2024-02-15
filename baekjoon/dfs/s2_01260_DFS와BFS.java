import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s2_01260_DFS와BFS {

    static int V;
    static int E;
    static int start;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("hansaem/algorithms/dfs/input/s2_01260.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];

        // 정점의 개수가 주어지기 때문에 처음부터 정점의 개수만큼 할당 가능함
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 생성
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            graph.get(out).add(in);
            graph.get(in).add(out);
        }

        // 그래프 출력
        int idx = 1;
        for (ArrayList<Integer> g : graph) {
            System.out.print(idx + ": ");
            for (int v : g) {
                System.out.print(v + ", ");
            }
            System.out.println();
            idx++;
        }

        dfs(start);
    }

    public static void dfs(int vertex) {
        visited[vertex] = true;

        System.out.print(vertex + " > ");

        for (int v : graph.get(vertex)) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}
