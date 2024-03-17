package 신고결과받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class kakao_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;

        Map<String, Integer> resultMap = new HashMap<>();

        Map<String, Set<String>> map = new HashMap<>();
        int len = id_list.length;
        answer = new int[len];
        for (String id : id_list) {
            Set<String> set = new HashSet<>();
            map.put(id, set);
            resultMap.put(id, 0);
        }

        for (String r : report) {
            String[] people = r.split(" ");
            String to = people[1];
            String from = people[0];

            Set<String> set = map.get(to);
            set.add(from);
            map.put(to, set);
        }

        for (String key : map.keySet()) {
            Set<String> set = map.get(key);

            if (set.size() >= k) {
                for (String str : set) {
                    resultMap.put(str, resultMap.get(str) + 1);
                }
            }
        }

        for (int i = 0; i < len; i++){
            answer[i] = resultMap.get(id_list[i]);
        }

        return answer;
    }
}
