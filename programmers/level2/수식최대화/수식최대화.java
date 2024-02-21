package level2.수식최대화;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {

    char[] op = new char[3];
    boolean[] used = new boolean[3];
    int len;
    long result;

    public long solution(String expression) {
        long answer = 0;

        List<String> list = new ArrayList<>();

        if (expression.contains("+"))
            op[len++] = '+';
        if (expression.contains("-"))
            op[len++] = '-';
        if (expression.contains("*"))
            op[len++] = '*';

        int start = 0;
        int end = 1;

        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                list.add(expression.substring(start, end - 1));
                list.add(ch + "");
                start = end;
            }
            end++;
        }
        list.add(expression.substring(start, end - 1));

        //System.out.println(op);
        //System.out.println(list);

        bt(0, list);

        return result;
    }

    void bt(int depth, List<String> list) {
        if (depth == len) {
            result = Math.max(result, Math.abs(Long.parseLong(list.get(0))));
            return;
        }

        List<String> tmp;

        for (int i = 0; i < len; i++) {
            //System.out.println("i: " + i + ", depth: " + depth);
            if (!used[i]) {
                tmp = new ArrayList<>(list);
                used[i] = true;
                bt(depth + 1, calculate(tmp, op[i]));
                used[i] = false;
            }
        }
    }

    List<String> calculate(List<String> list, char op) {

        //System.out.println(op + " >> " + list);

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(String.valueOf(op))) {
                long left = Long.parseLong(list.get(i - 1));
                long right = Long.parseLong(list.get(i + 1));

                if (op == '+') {
                    list.set(i - 1, left + right + "");
                } else if (op == '-') {
                    list.set(i - 1, left - right + "");
                } else {
                    list.set(i - 1, left * right + "");
                }

                list.remove(i);
                list.remove(i);
                i--;
            }
        }

        //System.out.println(op + " >> " + list);
        //System.out.println();

        return list;
    }
}
