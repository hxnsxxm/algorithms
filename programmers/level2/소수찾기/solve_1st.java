package level2.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class solve_1st {
    class Solution {
        Set<Integer> set = new HashSet<>();
        int len;
        String input;
        boolean[] used;

        public int solution(String numbers) {
            len = numbers.length();
            input = numbers;
            used = new boolean[len];
            for (int i = 1; i <= len; i++) {
                bt(0, i, "");
            }

            return set.size();
        }

        void bt(int depth, int goal, String str) {
            if (depth == goal) {
                if (isPrime(str)) {
                    set.add(Integer.parseInt(str));
                }

                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    used[i] = true;
                    bt(depth + 1, goal, str + input.charAt(i));
                    used[i] = false;
                }
            }
        }

        boolean isPrime(String str) {
            int num = Integer.parseInt(str);

            if (num == 0 || num == 1)
                return false;
            if (num == 2 || num == 3)
                return true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }

            return true;
        }
    }
}
