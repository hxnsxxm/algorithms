package 개인정보수집유효기간;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        LocalDate todayLd = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        for (String term : terms) {
            String[] tmp = term.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        int cnt = 1;
        for (String privacy : privacies) {
            String[] tmp = privacy.split(" ");
            LocalDate startLd = LocalDate.parse(tmp[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            int mon = map.get(tmp[1]);

            if (startLd.plusMonths(mon).minusDays(1).isBefore(todayLd)) {
                list.add(cnt);
            }

            cnt++;
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
