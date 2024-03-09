package level3.보석쇼핑;

import java.util.HashMap;
import java.util.Map;

public class 보석쇼핑_fail {

    String[] gs;
    int len;

    public int[] solution(String[] gems) {
        int[] answer = {};

        gs = gems;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> lMap;
        len = gems.length;

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
        }
        lMap = new HashMap<>(map);

        //System.out.println(map);

        int right = rightIndex(map, 0);
        int left = leftIndex(map, right);

        //System.out.println("right: " + right);
        //System.out.println("left: " + left);

        int lLeft = leftIndex(lMap, len);
        int lRight = rightIndex(lMap, lLeft - 1);

        //System.out.println("lRight: " + lRight);
        //System.out.println("lLeft: " + lLeft);

        if (right - left <= lRight - lLeft)
            answer = new int[]{left, right};
        else
            answer = new int[]{lLeft, lRight};


        return answer;
    }

    int rightIndex(Map<String, Integer> map, int limit) {
        int right = 0;
        for (int i = len - 1; i >= limit; i--) {
            String gem = gs[i];
            int num = map.get(gem);

            if (num >= 2)
                map.put(gem, num - 1);
            else { //map.get(gem) == 1
                right = i + 1;
                break;
            }
        }

        return right;
    }

    int leftIndex(Map<String, Integer> map, int limit) {
        int left = 0;
        for (int i = 0; i < limit; i++) {
            String gem = gs[i];
            int num = map.get(gem);

            if (num >= 2)
                map.put(gem, num - 1);
            else { //map.get(gem) == 1
                left = i + 1;
                break;
            }
        }

        return left;
    }
}
