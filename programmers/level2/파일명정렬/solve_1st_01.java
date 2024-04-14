package level2.파일명정렬;

import java.util.Arrays;
import java.util.Comparator;

public class solve_1st_01 {
    class Solution {
        public String[] solution(String[] files) {
            int len = files.length;
            String[] answer = new String[len];
            String[][] tmp = new String[len][3];

            for (int i = 0; i < len; i++) {
                tmp[i] = classify(files[i]);
                //System.out.println(Arrays.toString(tmp[i]));
            }

            //정렬
            Arrays.sort(tmp, new Comparator<String[]>(){
                @Override
                public int compare(String[] s1, String[] s2) {
                    String l1 = s1[0].toLowerCase();
                    String l2 = s2[0].toLowerCase();

                    if (l1.equals(l2))
                        return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);

                    return l1.compareTo(l2);//s1[0].compareTo(s2[0]);
                }
            });
            // for (String[] t : tmp)
            //     System.out.println(Arrays.toString(t));

            //answer 변환
            for (int i = 0; i < len; i++) {
                answer[i] = tmp[i][0] + tmp[i][1] + tmp[i][2];
            }

            return answer;
        }

        String[] classify(String file) {
            int len = file.length();
            String[] str = new String[3];

            int s = 0;
            int e = 0;

            while (!('0' <= file.charAt(e) && file.charAt(e) <= '9')) {
                e++;
            }
            str[0] = file.substring(s, e);
            s = e;

            while ('0' <= file.charAt(e) && file.charAt(e) <= '9') {
                e++;
                if (e >= len)
                    break;
            }
            if (e < len) {
                str[1] = file.substring(s, e);
                s = e;

                str[2] = file.substring(s);
            } else {
                str[1] = file.substring(s);
                str[2] = "";
            }

            return str;
        }
    }
}
