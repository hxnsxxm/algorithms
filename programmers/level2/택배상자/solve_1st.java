package level2.택배상자;

import java.util.Stack;

public class solve_1st {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;

            int len = order.length;
            Stack<Integer> stack = new Stack<>();
            int idx = 0;
            for (int i = 1; i <= len; i++) {
                if (i == order[idx]) {
                    answer++;
                    idx++;
                } else {
                    stack.push(i);
                }

                while (!stack.isEmpty() && stack.peek() == order[idx]) {
                    answer++;
                    stack.pop();
                    idx++;
                }
            }

            return answer;
        }
    }
}
