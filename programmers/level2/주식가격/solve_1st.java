package level2.주식가격;

import java.util.Stack;

public class solve_1st {
    class Solution {
        public int[] solution(int[] prices) {
            int len = prices.length;
            int[] answer = new int[len];
            Stack<Integer> stack = new Stack<>();

            stack.push(0);
            for (int i = 1; i < len; i++) {
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                answer[idx] = len - idx - 1;
            }

            return answer;
        }
    }
}
