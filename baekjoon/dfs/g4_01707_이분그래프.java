import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class g4_01707_이분그래프 {

    static ArrayList<Integer>[] graph;
    static int T;
    static int V;
    static int E;
    //static Map<Integer, String> statusMap = new HashMap<>();
    static int[] visitStatus;
    static String answer;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dfs/input/g4_01707.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            visitStatus = new int[V + 1];
            answer = "YES";
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int source = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());

                graph[source].add(destination);
                graph[destination].add(source);
            }

            for (int v = 1; v <= V; v++) {
                if (visitStatus[v] == 0)
                    dfs(v, 1);
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int vertex, int status) {
        //statusMap.put(vertex, status);
        visitStatus[vertex] = status;

        int nextStatus = status == 1 ? 2 : 1;

        for (int node : graph[vertex]) {
            if (visitStatus[node] == status) { // 방문함
                answer = "NO";
                return;
            } else if (visitStatus[node] == 0) {
                dfs(node, nextStatus);
            }
        }
    }
}
