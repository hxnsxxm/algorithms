package level3.표편집;

import java.util.Stack;

public class solve_1st {
    public String solution(int n, int k, String[] cmd) {
        int curr = k;
        int tableSize = n;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String c : cmd) {
            char ch = c.charAt(0);

            if (ch == 'U') {
                curr -= Integer.parseInt(c.substring(2));
            } else if (ch == 'D') {
                curr += Integer.parseInt(c.substring(2));
            } else if (ch == 'C') {
                stack.push(curr);
                tableSize--;
                curr = curr >= tableSize ? tableSize - 1 : curr;
            } else if (ch == 'Z') {
                int tmp = stack.pop();
                tableSize++;
                curr = tmp <= curr ? curr + 1 : curr;
            }
        }

        for (int i = 0; i < tableSize; i++)
            sb.append("O");
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }
}
