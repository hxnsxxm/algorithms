import java.util.HashMap;
import java.util.Map;

public class kakao_가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int numOfFriends = friends.length;
        int[][] presents = new int[numOfFriends][numOfFriends];
        Map<String, Integer> map = new HashMap<>();
        int[] next = new int[numOfFriends];
        int[] fromAndTo = new int[numOfFriends];

        for (int i = 0; i < numOfFriends; i++) {
            map.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] str = gift.split(" ");
            int from = map.get(str[0]);
            int to = map.get(str[1]);

            presents[from][to]++;
            fromAndTo[from]++;
            fromAndTo[to]--;
        }

        for (int from = 0; from < numOfFriends; from++) {
            for (int to = 0; to < numOfFriends; to++) {
                int first = presents[from][to];
                int second = presents[to][from];
                int firstNum = fromAndTo[from];
                int secondNum = fromAndTo[to];

                if ((first > second) || (second == first && firstNum > secondNum)) {
                    next[from]++;
                }
            }
        }

        for (int i = 0; i < numOfFriends; i++) {
            answer = Math.max(answer, next[i]);
        }

        return answer;
    }
}
