package 잃어버린괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 잃어버린괄호 {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/잃어버린괄호/s2_01541.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        String input = br.readLine();

        StringBuffer sb = new StringBuffer();
        for (char ch : input.toCharArray()) {
            if (ch == '+' || ch == '-') {
                list.add(sb.toString());
                list.add(ch + "");
                sb.delete(0, sb.length());
            } else {
                sb.append(ch);
            }
        }
        list.add(sb.toString());

        //System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+")) {
                int pre = Integer.parseInt(list.get(i - 1));
                int next = Integer.parseInt(list.get(i + 1));
                list.set(i - 1, String.valueOf(pre + next));

                list.remove(i);
                list.remove(i);
                i--;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("-")) {
                int pre = Integer.parseInt(list.get(i - 1));
                int next = Integer.parseInt(list.get(i + 1));
                list.set(i - 1, String.valueOf(pre - next));

                list.remove(i);
                list.remove(i);
                i--;
            }
        }

        System.out.print(list.get(0));
    }
}
