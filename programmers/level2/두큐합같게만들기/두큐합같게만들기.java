package level2.두큐합같게만들기;

public class 두큐합같게만들기 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        int len = queue1.length;
        int total_len = 2*len;
        long goal = 0;
        long sum1 = 0;
        long sum2 = 0;

        int[] total = new int[total_len];
        for (int i = 0; i < len; i++) {
            total[i] = queue1[i];
            total[i + len] = queue2[i];
            sum1 += total[i];
            sum2 += total[i + len];
        }

        goal = (sum1 + sum2)/2;

        int s1 = 0;
        int e1 = len -1;
        int s2 = len;
        int e2 = 2*len - 1;

        while (sum1 != goal) {
            if (sum1 < goal) {
                e1 = (e1 + 1)%total_len;
                s2 = (s2 + 1)%total_len;
                sum1 += total[e1];
            } else if (sum1 > goal) {
                s1 = (s1 + 1)%total_len;
                e2 = (e2 + 1)%total_len;
                sum1 -= total[e2];
            }
            answer += 1;

            if (answer == 2 * total_len) {
                answer = -1;
                break;
            }
        }


        return answer;
    }
}
