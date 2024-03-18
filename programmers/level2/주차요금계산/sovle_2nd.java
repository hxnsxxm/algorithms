package level2.주차요금계산;

import java.util.Map;
import java.util.TreeMap;

public class sovle_2nd {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new TreeMap<>();

        for (String r : records) {
            String[] t = r.split(" ");

            int time = t[2].equals("IN") ? -1 : 1;
            time *= timeToInt(t[0]);
            map.put(t[1], map.getOrDefault(t[1], 0) + time);
        }

        int cnt = 0, answer[] = new int[map.size()];
        for (int time : map.values()) {
            if (time < 1) //"00:00"에 입차하는 경우 0
                time += timeToInt("23:59");
            time -= fees[0];
            int cost = fees[1];
            if (time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2] + 1)*fees[3];
            answer[cnt++] = cost;
        }

        return answer;
    }

    int timeToInt(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}
