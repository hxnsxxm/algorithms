import java.util.HashMap;
import java.util.Map;

public class kakao_성격유형검사하기 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        char[][] types = {
                {'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}
        };

        Map<Character, Integer> map = new HashMap<>();
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        int[] results = new int[4];
        int len = survey.length;

        for (char[] type : types) {
            map.put(type[0], 0);
            map.put(type[1], 0);
        }

        for (int i = 0; i < len; i++) {
            int choice = choices[i];
            int score = scores[choice];
            String sur = survey[i];
            char left = sur.charAt(0);
            char right = sur.charAt(1);

            if (choice < 4) {
                map.put(left, map.get(left) + score);
            } else if (choice > 4) {
                map.put(right, map.get(right) + score);
            }
        }

        for (char[] type : types) {
            char left = type[0];
            char right = type[1];
            int leftScore = map.get(left);
            int rightScore = map.get(right);

            if (leftScore < rightScore)
                answer += right;
            else if (leftScore >= rightScore)
                answer += left;
        }


        return answer;
    }
}
