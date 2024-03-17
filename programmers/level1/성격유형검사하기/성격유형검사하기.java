package 성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

    private static int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
    private static String[][] type = {
            {"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}
    };

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String[] t : type) {
            map.put(t[0], 0);
            map.put(t[1], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String first = survey[i].charAt(0) + "";
            String second = survey[i].charAt(1) + "";

            if (choices[i] < 4) {
                map.put(first, map.get(first) + score[choices[i]]);
            } else if (choices[i] > 4) {
                map.put(second, map.get(second) + score[choices[i]]);
            }
        }

        for (String[] t : type) {
            if (map.get(t[0]) >= map.get(t[1]))
                answer += t[0];
            else
                answer += t[1];
        }

        return answer;
    }
}
