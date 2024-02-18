package level2.k진수에서소수개수구하기;

import java.util.StringTokenizer;

public class k진수에서소수개수구하기 {

    public int solution(int n, int k) {
        int answer = 0;

        StringTokenizer st = transform(n, k);
        // Integer.toString(n, k).split("0"); 에서 동일한 동작

        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            if (isPrimeNumber(num)) {
                answer += 1;
            }
        }

        return answer;
    }

    StringTokenizer transform(int n, int k) {

        StringBuffer sb = new StringBuffer();

        while (true) {
            int tmp = n/k;
            sb.append(n%k);
            if (tmp == 0)
                break;
            n /= k;
        }

        return new StringTokenizer(sb.reverse().toString(), "0");
    }

    boolean isPrimeNumber(long num) {
        if (num == 1)
            return false;

        for (long i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
