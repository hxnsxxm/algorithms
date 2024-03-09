package level3.보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 보석쇼핑_solution {
    public int[] solution(String[] gems) {
        int kind = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, start = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            //구간을 판별하는 구분
            //- kind: 보석 종류
            //- length: 현재까지 가장 짧은 구간
            if (map.size() == kind && length > (end - start)) {
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }
}
