package 가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {

    private static int[][] history;
    private static int[] rate;
    private static Map<String, Integer> map = new HashMap<>();

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        history = new int[friends.length][friends.length];
        rate = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        for (String g : gifts) {
            String[] t = g.split(" ");
            history[map.get(t[0])][map.get(t[1])] += 1;
            rate[map.get(t[0])] += 1;
            rate[map.get(t[1])] -= 1;
        }

        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j)
                    continue;
                if (history[i][j] > history[j][i])
                    cnt += 1;
                else if (history[i][j] == history[j][i] && rate[i] > rate[j]) {
                    cnt += 1;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
