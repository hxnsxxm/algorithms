package level3.경주로건설;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
테스트 1 〉	통과 (0.19ms, 77.1MB)
테스트 2 〉	통과 (0.15ms, 81MB)
테스트 3 〉	통과 (0.20ms, 76.5MB)
테스트 4 〉	통과 (0.18ms, 76.6MB)
테스트 5 〉	통과 (0.27ms, 80.8MB)
테스트 6 〉	통과 (2.44ms, 78.2MB)
테스트 7 〉	통과 (3.47ms, 72.1MB)
테스트 8 〉	통과 (3.57ms, 72.9MB)
테스트 9 〉	통과 (1.26ms, 75.7MB)
테스트 10 〉	통과 (6.05ms, 75.8MB)
테스트 11 〉	통과 (757.87ms, 413MB)
테스트 12 〉	통과 (13.64ms, 79.1MB)
테스트 13 〉	통과 (0.73ms, 76.3MB)
테스트 14 〉	통과 (0.94ms, 70.4MB)
테스트 15 〉	통과 (3.35ms, 79.8MB)
테스트 16 〉	통과 (15.11ms, 80.8MB)
테스트 17 〉	통과 (21.74ms, 80.6MB)
테스트 18 〉	통과 (39.33ms, 84.9MB)
테스트 19 〉	통과 (61.41ms, 104MB)
테스트 20 〉	통과 (3.33ms, 79MB)
테스트 21 〉	통과 (1.88ms, 81.1MB)
테스트 22 〉	통과 (0.35ms, 74.1MB)
테스트 23 〉	통과 (0.33ms, 76.9MB)
테스트 24 〉	통과 (0.29ms, 73.6MB)
테스트 25 〉	통과 (0.16ms, 72.2MB)
 */
public class 경주로건설_success {

    int N;
    int[][] board;
    int[][][] costs;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int solution(int[][] board) {
        int answer = 0;

        this.board = board;
        N = board.length;
        costs = new int[N][N][4];
        for (int[][] two : costs)
            for (int[] one : two)
                Arrays.fill(one, Integer.MAX_VALUE);

        costs[0][0] = new int[]{0, 0, 0, 0};

        return bfs(0, 0);
    }

    int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>(); //0: r, 1: c, 2: direction
        queue.add(new int[]{r, c, 0});
        int result = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            r = info[0];
            c = info[1];
            int preDir = info[2];

            for(int i = 0; i < 4; i++) {
                int tr = r + dr[i];
                int tc = c + dc[i];

                if (tr < 0 || tc < 0 || tc >= N || tr >= N)
                    continue;
                if (board[tr][tc] == 1)
                    continue;

                int newCost = costs[r][c][preDir];
                if ((r == 0 && c == 0) || i == preDir)
                    newCost += 100;
                else
                    newCost += 600;

                if (costs[tr][tc][i] >= newCost) {
                    queue.add(new int[]{tr, tc, i});
                    costs[tr][tc][i] = newCost;

                    if (tr == N - 1 && tc == N - 1)
                        result = Math.min(result, costs[N - 1][N - 1][i]);
                }
            }
        }

        return result;
    }
}
