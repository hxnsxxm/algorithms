package level2.스킬트리;

public class solve_1st {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            int len = skill.length();
            for (String s : skill_trees) {
                int prev = s.indexOf(skill.charAt(0));
                if (len == 1)
                    answer++;
                for (int i = 1; i < len; i++) {
                    int curr = s.indexOf(skill.charAt(i));
                    if (prev == -1 && curr >= 0) break;
                    if (curr != -1 && prev > curr) break;
                    if (i == len - 1) answer++;
                    prev = curr;
                }
            }

            return answer;
        }
    }
}
