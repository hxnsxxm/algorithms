package level2.순위검색;

import java.util.LinkedList;
import java.util.StringTokenizer;

/*
정확성  테스트
테스트 1 〉	통과 (2.35ms, 80.8MB)
테스트 2 〉	통과 (1.63ms, 77.3MB)
테스트 3 〉	통과 (7.02ms, 79.2MB)
테스트 4 〉	통과 (17.68ms, 88.2MB)
테스트 5 〉	통과 (39.21ms, 87.6MB)
테스트 6 〉	통과 (37.06ms, 83.2MB)
테스트 7 〉	통과 (31.35ms, 90.9MB)
테스트 8 〉	통과 (71.34ms, 100MB)
테스트 9 〉	통과 (73.16ms, 91.7MB)
테스트 10 〉	통과 (73.75ms, 83.8MB)
테스트 11 〉	통과 (27.94ms, 89.1MB)
테스트 12 〉	통과 (48.64ms, 84MB)
테스트 13 〉	통과 (40.09ms, 94.7MB)
테스트 14 〉	통과 (68.94ms, 111MB)
테스트 15 〉	통과 (78.76ms, 103MB)
테스트 16 〉	통과 (24.25ms, 91MB)
테스트 17 〉	통과 (41.19ms, 99.2MB)
테스트 18 〉	통과 (73.41ms, 105MB)

효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)

채점 결과
정확성: 40.0
효율성: 0.0
합계: 40.0 / 100.0
 */
public class 순위검색2_정확성40_효율성0 {

    String[][] applicants;
    int len;
    boolean[] valid;

    public int[] solution(String[] info, String[] query) {

        StringTokenizer st;

        len = info.length;
        int[] answer = new int[query.length];
        applicants = new String[len][5];
        for (int i = 0; i < len; i++) {
            String[] tmp = info[i].split(" ");

            applicants[i] = tmp;
        }

        for (int i = 0; i < query.length; i++) {
            String[] tmp = query[i].split("\\s*and\\s*| ");

            valid = new boolean[len];
            answer[i] = validation(tmp);
        }

        return answer;
    }

    int validation(String[] ap) {
        //System.out.println("---");
        //System.out.println(list.size());
        if (!ap[0].equals("-")) {
            for (int i = 0; i < len; i++) {
                if (!applicants[i][0].equals(ap[0]))
                    valid[i] = true;
            }
        }

        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[1].equals("-")) {
            for (int i = 0; i < len; i++) {
                if (!applicants[i][1].equals(ap[1]))
                    valid[i] = true;
            }
        }
        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[2].equals("-")) {
            for (int i = 0; i < len; i++) {
                if (!applicants[i][2].equals(ap[2]))
                    valid[i] = true;
            }
        }
        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[3].equals("-")) {
            for (int i = 0; i < len; i++) {
                if (!applicants[i][3].equals(ap[3]))
                    valid[i] = true;
            }
        }
        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[4].equals("-")) {
            for (int i = 0; i < len; i++) {
                if (Integer.parseInt(applicants[i][4]) < Integer.parseInt(ap[4]))
                    valid[i] = true;
            }
        }
        //System.out.println(list.size());
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (!valid[i])
                cnt++;
        }

        return cnt;
    }
}
