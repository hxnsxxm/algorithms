package level3.합승택시요금;

import java.util.Arrays;

public class 합승택시요금 {

    int[][] costs; //인덱스 1부터 사용
    int INF = 1000000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        costs = new int[n + 1][n + 1];
        for (int[] c : costs)
            Arrays.fill(c, INF);
        for (int[] f : fares)
            costs[f[0]][f[1]] = costs[f[1]][f[0]] = f[2];
        for (int i = 1; i <= n; i++)
            costs[i][i] = 0;

        // for (int[] c : costs)
        //     System.out.println(Arrays.toString(c));
        // System.out.println("*****");

        //플로이드-와샬
        for (int i = 1; i <= n; i++) {
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    costs[r][c] = Math.min(costs[r][c], costs[r][i] + costs[i][c]);
                }
            }
        }
        answer = costs[s][a] + costs[s][b];

        // for (int[] c : costs)
        //     System.out.println(Arrays.toString(c));

        //동승할 지역 반복
        for (int i = 1; i <= n; i++) {
            if (i == s)
                continue;

            int currCost = 0;
            //동승지까지의 택시요금 계산
            currCost = costs[s][i];

            //동승지부터 A 요금
            currCost += costs[i][a];

            //동승지부터 B 요금
            currCost += costs[i][b];

            if (currCost < 0)
                continue;

            answer = Math.min(answer, currCost);
        }

        return answer;
    }
}
