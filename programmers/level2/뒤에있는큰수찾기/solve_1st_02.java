package level2.뒤에있는큰수찾기;

import java.util.Arrays;
import java.util.Stack;

public class solve_1st_02 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Arrays.fill(answer, -1);
            Stack<Integer> s = new Stack<>();
            s.push(0);
            for(int i = 1; i < numbers.length; i++){
                while(!s.isEmpty()){
                    int idx = s.pop();
                    if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
                        answer[idx] = numbers[i];
                    } else { // 앞이 더 크거나 같을 때
                        s.push(idx);
                        break;
                    }
                }
                s.push(i);
            }

            return answer;
        }
    }
}
