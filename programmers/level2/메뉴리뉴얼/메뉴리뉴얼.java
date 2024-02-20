package level2.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼 {

    Map<String, Integer> map = new HashMap<>();
    int len;
    int[] max_num;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        StringBuffer sb;// = new StringBuffer();
        List<String> list = new ArrayList<>();
        max_num = new int[11];

        for (String order : orders) {
            len = order.length();
            //System.out.println(order);

            char[] chs = order.toCharArray();
            Arrays.sort(chs);
            order = new String(chs);

            //System.out.println("sorted : " + order);

            for (int num : course) {
                if (num > len)
                    break;
                if (num == len) {
                    map.put(order, map.getOrDefault(order, 0) + 1);
                    max_num[num] = Math.max(max_num[num], map.get(order));
                    break;
                }
                sb = new StringBuffer();
                //System.out.println("num : " + num);
                bt(0, 0, num, sb, order);
                //System.out.println("======");
            }
        }

        //System.out.println(map);

        for (String key : map.keySet()) {
            if (map.get(key) >= 2 && map.get(key) == max_num[key.length()]) {
                list.add(key);
            }
        }

        //System.out.println(list);
        Collections.sort(list);
        //System.out.println(list);

        return list.toArray(new String[0]);
    }

    void bt(int depth, int start, int limit, StringBuffer sb, String order) {
        if (depth == limit) {
            //System.out.println("sb: " + sb.toString());
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            max_num[limit] = Math.max(max_num[limit], map.get(sb.toString()));
            return;
        }

        for (int i = start; i < len; i++) {
            sb.append(order.charAt(i));
            //System.out.println(sb.toString());
            bt(depth + 1, i + 1, limit, sb, order);
            sb.delete(depth, depth + 1);
            //System.out.println(sb.toString());
        }
    }
}
