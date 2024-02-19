package level2.주차요금계산;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        List<String> sortedNum = new ArrayList<>();

        Map<String, Integer> timesPerCar = new HashMap<>();
        Map<String, Integer> intoPark = new HashMap<>();

        for (String record : records) {
            String[] rec = record.split(" ");

            int time = stringToInt(rec[0]);
            String number = rec[1];
            String status = rec[2];

            if (!timesPerCar.containsKey(number)) {
                sortedNum.add(number);
                timesPerCar.put(number, 0);
            }

            if (status.equals("IN")) {
                intoPark.put(number, time);
            } else {
                int in = intoPark.get(number);
                intoPark.remove(number);
                timesPerCar.put(number, timesPerCar.get(number) + time - in);
            }
        }

        Collections.sort(sortedNum);

        for (String key : intoPark.keySet()) {
            int in = intoPark.get(key);
            timesPerCar.put(key, timesPerCar.getOrDefault(key, 0) + stringToInt("23:59") - in);
        }

        for (String key : sortedNum) {
            int time = timesPerCar.get(key);
            if (time <= fees[0]) {
                list.add(fees[1]);
            } else {
                list.add(fees[1] + calculateFee(time - fees[0], fees[2], fees[3]));
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    int stringToInt(String time) {
        String[] tmp = time.split(":");

        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }

    // 초과분, 기준 분
    int calculateFee(int time, int per, int fee) {
        return time/per * fee + (time%per > 0 ? fee : 0);
    }
}
