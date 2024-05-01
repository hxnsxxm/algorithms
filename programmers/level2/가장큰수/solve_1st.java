package level2.가장큰수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class solve_1st {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            List<String> str = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                str.add(String.valueOf(numbers[i]));
            }

            Collections.sort(str, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return (s2+s1).compareTo(s1+s2);
                }
            });

            if (str.get(0).equals("0"))
                return "0";

            return String.join("", str);
        }
    }
}
