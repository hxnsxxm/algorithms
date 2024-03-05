package level2.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 순위검색3_정확성40_효율성60 {

    Map<String, List<Integer>> map = new HashMap<>();
    int info_len;
    int query_len;

    public int[] solution(String[] info, String[] query) {
        info_len = info.length;
        query_len = query.length;

        int[] answer = new int[query_len];

        for (int i = 0; i < info_len; i++) {
            bt(0, info[i].split(" "), "");
        }

        for (String key : map.keySet())
            Collections.sort(map.get(key));

        for (int i = 0; i < query_len; i++) {
            String key = query[i].replaceAll(" and ", "");
            String[] q = key.split(" ");
            answer[i] = map.containsKey(q[0]) ? binarysearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    void bt(int depth, String[] applicant, String str) {
        if (depth == 4) {
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(Integer.parseInt(applicant[depth]));
            return;
        }

        bt(depth + 1, applicant, str + "-");
        bt(depth + 1, applicant, str + applicant[depth]);
    }

    int binarysearch(String key, int value) {
        List<Integer> list = map.get(key);
        //System.out.println(list);
        int start = 0;
        int end = list.size() - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (list.get(mid) < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
}
