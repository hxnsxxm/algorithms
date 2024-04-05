package level2.뒤에있는큰수찾기;

import java.util.Comparator;
import java.util.PriorityQueue;

public class solve_1st_01 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];


            PriorityQueue<Integer[]> q = new PriorityQueue<>(new Comparator<Integer[]>(){
                @Override
                public int compare(Integer[] n1, Integer[] n2) {
                    return n1[0] - n2[0];
                }
            });

            for (int i = 0; i < numbers.length; i++) {
                Integer num = numbers[i];
                q.add(new Integer[]{num, i});

                while (!q.isEmpty()) {
                    Integer[] n = q.peek();
                    if (num > n[0]) {
                        n = q.poll();
                        answer[n[1]] = num;
                    } else {
                        break;
                    }
                }
            }

            while (!q.isEmpty()) {
                Integer[] n = q.poll();
                answer[n[1]] = -1;
            }

            return answer;
        }
    }
}
