package level2.마법의엘리베이터;

public class solve_1st {
    class Solution {
        public int solution(int storey) {
            int answer = 0;

            while (storey > 0) {
                int n = storey % 10;
                storey /= 10;

                if (n == 5) {
                    if (storey % 10 >= 5) {
                        answer += 10 - n;
                        storey++;
                    } else {
                        answer += n;
                    }
                } else if (n < 5) {
                    answer += n;
                } else {
                    answer += 10 - n;
                    storey++;
                }
            }

            return answer;
        }
    }
}
