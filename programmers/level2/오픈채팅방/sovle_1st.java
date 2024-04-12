package level2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sovle_1st {
    class Solution {
        public String[] solution(String[] record) {
            int len = record.length;
            List<String> answer = new ArrayList<>();
            Map<String, String> map = new HashMap<>(); //유저아이디 : 닉네임
            String[][] admin = new String[len][2];

            for (int i = 0; i < len; i++) {
                String[] tmp = record[i].split(" ");

                if (tmp[0].equals("Enter")) {
                    map.put(tmp[1], tmp[2]);
                    admin[i][1] = "님이 들어왔습니다.";
                } else if (tmp[0].equals("Leave")) {
                    admin[i][1] = "님이 나갔습니다.";
                } else if (tmp[0].equals("Change")) {
                    map.put(tmp[1], tmp[2]);
                }
                admin[i][0] = tmp[1];
            }

            for (int i = 0; i < len; i++) {
                if (admin[i][1] == null)
                    continue;
                answer.add(map.get(admin[i][0]) + admin[i][1]);
            }

            return answer.stream().toArray(String[]::new);
        }
    }
}
