package level2.더맵게;

import java.util.PriorityQueue;

public class solve_1st {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> q = new PriorityQueue<>();

            for (int s : scoville)
                q.add(s);

            while (q.size() > 1 && q.peek() < K) {
                int s1 = q.poll();
                int s2 = q.poll();

                q.add(s1 + s2 * 2);
                answer++;
            }

            if (q.size() == 1 && q.peek() < K)
                answer = -1;

            return answer;
        }
    }
}
