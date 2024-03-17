package level3.파괴되지않은건물;

/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 72.6MB)
테스트 2 〉	통과 (0.03ms, 70.7MB)
테스트 3 〉	통과 (0.06ms, 77.1MB)
테스트 4 〉	통과 (0.15ms, 74.1MB)
테스트 5 〉	통과 (0.42ms, 76.8MB)
테스트 6 〉	통과 (0.82ms, 77.3MB)
테스트 7 〉	통과 (1.22ms, 73.3MB)
테스트 8 〉	통과 (1.10ms, 76.7MB)
테스트 9 〉	통과 (1.43ms, 72.8MB)
테스트 10 〉	통과 (2.29ms, 80.7MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
 */
public class 파괴되지않은건_정확성53_효율성0 {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    if (type == 1)
                        board[r][c] -= degree;
                    else
                        board[r][c] += degree;
                }
            }

            // for (int[] b : board)
            //     System.out.println(Arrays.toString(b));
            // System.out.println("-----");
        }

        for (int[] b : board) {
            for (int c : b) {
                if (c > 0)
                    answer++;
            }
        }

        return answer;
    }
}
