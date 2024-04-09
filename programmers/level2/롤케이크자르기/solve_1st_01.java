package level2.롤케이크자르기;

import java.util.HashMap;
import java.util.Map;

public class solve_1st_01 {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            Map<Integer, Integer> leftMap = new HashMap<>();
            Map<Integer, Integer> rightMap = new HashMap<>();

            //init
            leftMap.put(topping[0], 1);
            for (int i = 1; i < topping.length; i++)
                rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);

            if (leftMap.size() == rightMap.size())
                answer++;

            for (int i = 1; i < topping.length - 1; i++) {
                int t = topping[i];
                leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);
                rightMap.put(t, rightMap.get(t) - 1);
                if (rightMap.get(t) == 0)
                    rightMap.remove(t);

                if (leftMap.size() == rightMap.size())
                    answer++;
            }

            return answer;
        }
    }
}
