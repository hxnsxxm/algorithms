package level2.k진수에서소수개수구하기;

public class solve_2nd {
    public int solution(int n, int k) {
        int answer = 0;

        String[] arr = Integer.toString(n, k).split("[0]{1,}");

        for (String num : arr) {
            answer += validate(num);
        }

        return answer;
    }

    int validate(String str) {
        long num = Long.parseLong(str);

        if (num == 1)
            return 0;
        if (num == 2 || num == 3)
            return 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return 0;
        }

        return 1;
    }
}
