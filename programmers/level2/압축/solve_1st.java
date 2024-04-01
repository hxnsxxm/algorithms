package level2.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solve_1st {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();

        int len = msg.length();
        Map<String, Integer> map = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), i - 'A' + 1);
        }
        // System.out.println(map);

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            sb.append(String.valueOf(msg.charAt(i)));
            String str = sb.toString();

            //포함
            if (map.containsKey(str)) {
                idx = map.get(str);

            }
            //미포함
            else {
                map.put(str, map.size() + 1);
                ans.add(idx);
                i--;
                sb.delete(0, sb.length());
            }
        }

        ans.add(idx);
        //System.out.println(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
