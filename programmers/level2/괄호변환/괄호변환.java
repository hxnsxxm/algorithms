package level2.괄호변환;

import java.util.LinkedList;
import java.util.Queue;

public class 괄호변환 {

    public String solution(String p) {
        String answer = "";

        answer = solve(p);

        return answer;
    }

    String solve(String str) {
        if (isCorrect(str))
            return str;

        int idx = 0;
        int len = str.length();
        int balance = 0;

        String u;
        String v;

        for (;idx < len;) {
            char ch = str.charAt(idx);

            if (ch == '(')
                balance++;
            else
                balance--;

            if (balance == 0)
                break;

            idx++;
        }

        u = str.substring(0, idx + 1);
        v = str.substring(idx + 1);

        System.out.println(u + " // " + v);

        if (!isCorrect(u)) {
            u = str.substring(1, idx);
            u = u.replaceAll("\\(", "t");
            u = u.replaceAll("\\)", "\\(");
            u = u.replaceAll("t", "\\)");

            return "(" + solve(v) + ")" + u;
        } else {
            return u + solve(v);
        }
    }

    boolean isCorrect(String str) {
        if (str.equals(""))
            return true;
        Queue<Character> queue = new LinkedList<>();

        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                if (queue.isEmpty())
                    return false;
                queue.poll();
            } else {
                queue.add('(');
            }
        }

        if (!queue.isEmpty())
            return false;

        return true;
    }
}
