package level2.택배배달과수거하기;

public class 택배배달과수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d_end = n - 1;
        int p_end = n - 1;

        while (d_end >= 0 || p_end >= 0) {
            int d_sum = cap;
            int p_sum = cap;

            while (d_end >= 0 && deliveries[d_end] == 0) {
                d_end--;
            }
            while (p_end >= 0 && pickups[p_end] == 0) {
                p_end--;
            }

            //System.out.println("d_end: " + d_end + ", p_end: " + p_end);
            answer += 2 * Math.max(d_end + 1, p_end + 1);

            while (d_end >= 0 && d_sum > 0) {
                if (deliveries[d_end] > d_sum) {
                    deliveries[d_end] -= d_sum;
                    d_sum = 0;
                } else {
                    d_sum -= deliveries[d_end--];
                }
            }

            while (p_end >= 0 && p_sum > 0) {
                if (pickups[p_end] > p_sum) {
                    pickups[p_end] -= p_sum;
                    p_sum = 0;
                } else {
                    p_sum -= pickups[p_end--];
                }
            }
        }


        return answer;
    }
}
