package level2.문자열압축;

public class 문자열압축 {
    public int solution(String s) {
        int answer = 1001;

        int len = s.length();
        int limit = len/2;
        StringBuffer sb;

        if (len == 1)
            answer = 1;

        for (int i = 1; i <= limit; i++) {
            int start = 0;
            int end = i;
            int cnt = 1;
            sb = new StringBuffer();

            String pre_str = s.substring(start, end);
            start += i;
            end += i;

            //System.out.println("i : " + i);
            while (start <= len) {
                String str;
                if (end > len)
                    str = s.substring(start);
                else
                    str = s.substring(start, end);

                //System.out.println("pre_str : " + pre_str + ", str : " + str + ", start : " + start + ", end : " + end);

                if (pre_str.equals(str)) {
                    cnt++;
                } else if (cnt > 1) {
                    sb.append(cnt).append(pre_str);
                    pre_str = str;
                    cnt = 1;
                } else {
                    sb.append(pre_str);
                    pre_str = str;
                    cnt = 1;
                }

                start += i;
                end += i;

                if (start > len) {
                    if (cnt > 1)
                        sb.append(cnt).append(str);
                    else
                        sb.append(str);
                }

            }

            answer = Math.min(answer, sb.length());
            //System.out.println("sb : " + sb.toString());
            //System.out.println();
        }


        return answer;
    }
}
