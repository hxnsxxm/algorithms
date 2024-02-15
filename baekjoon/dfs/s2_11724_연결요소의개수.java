import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s2_11724_연결요소의개수 {

    static int V; // N
    static int E; // M
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("hansaem/algorithms/dfs/input/s2_11724.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        answer = 0;

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            graph[out].add(in);
            graph[in].add(out);
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                answer += 1;
                dfs(i);
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int vertex) {
        visited[vertex] = true;

        for (int node : graph[vertex]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
