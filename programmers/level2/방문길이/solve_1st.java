package level2.방문길이;

import java.util.HashSet;
import java.util.Set;

public class solve_1st {
    class Solution {
        public int solution(String dirs) {
            int answer = 0;

            Set<String> set = new HashSet<>();
            int[] dx = {1, 0, -1, 0}; //우 하 좌 상
            int[] dy = {0, -1, 0, 1};
            int x = 0;
            int y = 0;
            StringBuilder sb = new StringBuilder();

            for (char ch : dirs.toCharArray()) {
                int tx = x;
                int ty = y;

                if (ch == 'R') {        //우
                    tx += dx[0];
                    ty += dy[0];
                } else if (ch == 'D') { //하
                    tx += dx[1];
                    ty += dy[1];
                } else if (ch == 'L') { //좌
                    tx += dx[2];
                    ty += dy[2];
                } else {                //상
                    tx += dx[3];
                    ty += dy[3];
                }

                if (tx < -5 || ty < -5 || tx > 5 || ty > 5)
                    continue;

                sb.append(x).append(y).append(tx).append(ty);
                set.add(sb.toString());
                sb.delete(0, sb.length());
                sb.append(tx).append(ty).append(x).append(y);
                set.add(sb.toString());
                sb.delete(0, sb.length());
                //System.out.println(sb.toString());
                x = tx;
                y = ty;

            }

            answer = set.size()/2;

            return answer;
        }
    }
}
