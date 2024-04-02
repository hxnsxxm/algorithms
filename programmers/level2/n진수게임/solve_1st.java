package level2.n진수게임;

public class solve_1st {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int tt = 0;
        int num = 0;
        int mm = 1;
        while (tt < t) {
            String nums = Integer.toString(num, n);

            for (char ch : nums.toCharArray()) {
                if (mm == p) {
                    answer += ch;
                    tt++;
                }
                mm = mm%m + 1;

                if (tt == t)
                    break;
            }

            num++;
        }

        return answer.toUpperCase();
    }
}
