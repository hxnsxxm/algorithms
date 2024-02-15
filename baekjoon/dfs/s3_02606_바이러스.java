import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s3_02606_바이러스 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int V;
    static int E;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("hansaem/algorithms/dfs/input/s3_02606.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            graph.get(out).add(in);
            graph.get(in).add(out);
        }

        answer = 0;
        dfs(1);

        bw.write((answer - 1) + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int vertex) {
        visited[vertex] = true;
        answer += 1;

        for (int node : graph.get(vertex)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

}
