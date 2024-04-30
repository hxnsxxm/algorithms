package level2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class solve_1st {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < bridge_length; i++)
                q.offer(0);

            int idx = 0;
            int total = 0;
            int sec = 0;

            while (idx < truck_weights.length) {
                total -= q.poll();
                sec++;

                if (total + truck_weights[idx] <= weight) {
                    q.offer(truck_weights[idx]);
                    total += truck_weights[idx];
                    idx++;
                }
                else
                    q.offer(0);
            }

            return sec + bridge_length;
        }
    }
}
