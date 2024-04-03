package level2.모음사전;

import java.util.TreeSet;

public class solve_1st {
    public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) {
            //System.out.println(per);
            answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        }
        return answer;
    }
}

/*
import java.util.*;

class Solution {
    TreeSet<String> set = new TreeSet<>();
    String[] chs = {"", "A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;

        bt(0, "");
        //System.out.println(set);

        answer = set.headSet(word, true).size();

        return answer;
    }

    void bt(int depth, String str) {
        if (depth == 5) {
            if (!str.equals("")) {
                set.add(str);
            }
            return;
        }

        for (int i = 0; i < 6; i++) {
            bt(depth + 1, str + chs[i]);
        }
    }
}
*/