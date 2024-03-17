package 숫자문자열과영단어;

public class kakao_숫자문자열과영단어 {

    public int solution(String s) {
        int answer = 0;

        String[][] nums = {
                {"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"},
                {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"}, {"nine", "9"}
        };

        for (String[] num : nums) {
            s = s.replaceAll(num[0], num[1]);
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
