package level2.도넛과막대그래프;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class 도넛과막대그래프 {

    Map<Integer, List<Integer>> inMap = new HashMap<>();
    Map<Integer, List<Integer>> outMap = new HashMap<>();
    boolean[] visited;
    int[] answer = new int[4];

    public int[] solution(int[][] edges) {


        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            int to = edges[i][0];
            int from = edges[i][1];

            outMap.computeIfAbsent(to, k -> new ArrayList<Integer>()).add(from);
            outMap.computeIfAbsent(from, k -> new ArrayList<Integer>());
            inMap.computeIfAbsent(from, k -> new ArrayList<Integer>()).add(to);
            inMap.computeIfAbsent(to, k -> new ArrayList<Integer>());
            max = Math.max(max, Math.max(to, from));
        }

        //System.out.println(inMap);

        int newEdge = 0;
        for (int key : inMap.keySet()) {
            //System.out.println(key + ", " + inMap.get(key).size() + outMap.get(key).size());
            if (inMap.get(key).size() == 0 && outMap.get(key).size() >= 2)
                newEdge = key;
        }

        //System.out.println(newEdge);
        answer[0] = newEdge;
        visited = new boolean[max + 1];
        for (int node : outMap.get(newEdge)) {
            //System.out.println(node);
            determine(node, newEdge);
        }

        return answer;
    }

    void determine(int node, int newEdge) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        int vertexCnt = 1;
        int edgeCnt = 0;

        //System.out.print(node + ": ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int n : outMap.get(vertex)) {
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    vertexCnt += 1;
                }
                edgeCnt += 1;
            }


            for (int n : inMap.get(vertex)) {
                if (n == newEdge)
                    continue;
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    vertexCnt += 1;
                }
                edgeCnt += 1;
            }
        }

        edgeCnt /= 2;
        //System.out.println(vertexCnt + ", " + edgeCnt);
        if (vertexCnt == edgeCnt)
            answer[1] += 1;
        else if (vertexCnt > edgeCnt)
            answer[2] += 1;
        else
            answer[3] += 1;
    }
}
