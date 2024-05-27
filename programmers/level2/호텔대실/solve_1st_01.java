package level2.호텔대실;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class solve_1st_01 {
    class Solution {
        public int solution(String[][] book_time) {
            int len = book_time.length;
            Integer[][] times = new Integer[len][2];
            for (int i = 0; i < len; i++) {
                times[i][0] = string2Sec(book_time[i][0]);
                times[i][1] = string2Sec(book_time[i][1]);
            }
            Arrays.sort(times, new Comparator<Integer[]>(){
                @Override
                public int compare(Integer[] s1, Integer[] s2) {
                    return s1[1] - s2[1];
                }
            });

            List<Integer> list = new ArrayList<>();

            list.add(times[0][1]);
            for (int i = 1; i < len; i++) {
                int currStart = times[i][0];
                int currEnd = times[i][1];

                int size = list.size();
                for (int j = 0; j < size; j++) {
                    if (currStart >= list.get(j) + 600) {
                        list.set(j, currEnd);
                        break;
                    } else if (j == size - 1) {
                        list.add(currEnd);
                    }
                }
                Collections.sort(list, Collections.reverseOrder());
            }

            return list.size();
        }

        private int string2Sec(String time) {
            String[] tmp = time.split(":");
            return Integer.parseInt(tmp[0]) * 60 * 60 + Integer.parseInt(tmp[1]) * 60;
        }
    }
}
