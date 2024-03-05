package level2.순위검색;

import java.util.LinkedList;
import java.util.StringTokenizer;

/*
정확성  테스트
테스트 1 〉	통과 (2.59ms, 71.7MB)
테스트 2 〉	통과 (1.75ms, 76.7MB)
테스트 3 〉	통과 (6.69ms, 76.8MB)
테스트 4 〉	통과 (21.14ms, 90.1MB)
테스트 5 〉	통과 (40.21ms, 90.3MB)
테스트 6 〉	통과 (80.82ms, 126MB)
테스트 7 〉	통과 (36.21ms, 103MB)
테스트 8 〉	통과 (1480.49ms, 123MB)
테스트 9 〉	통과 (1463.25ms, 103MB)
테스트 10 〉	통과 (1487.31ms, 130MB)
테스트 11 〉	통과 (48.31ms, 117MB)
테스트 12 〉	통과 (115.36ms, 129MB)
테스트 13 〉	통과 (64.67ms, 101MB)
테스트 14 〉	통과 (533.84ms, 99.9MB)
테스트 15 〉	통과 (518.88ms, 124MB)
테스트 16 〉	통과 (30.91ms, 96.6MB)
테스트 17 〉	통과 (83.06ms, 106MB)
테스트 18 〉	통과 (465.46ms, 102MB)

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
public class 순위검색1_정확성40_효율성0 {

    LinkedList<String[]> applicants = new LinkedList<>();
    int len;

    public int[] solution(String[] info, String[] query) {

        StringTokenizer st;

        len = info.length;
        int[] answer = new int[query.length];
        for (int i = 0; i < len; i++) {
            String[] tmp = info[i].split(" ");

            applicants.add(tmp);
        }

        for (int i = 0; i < query.length; i++) {
            String[] tmp = query[i].split("\\s*and\\s*| ");
            //System.out.println(Arrays.toString(tmp));
            LinkedList<String[]> list = new LinkedList<>(applicants);
            answer[i] = validation(tmp, list);
        }

        return answer;
    }

    int validation(String[] ap, LinkedList<String[]> list) {
        //System.out.println("---");
        //System.out.println(list.size());
        if (!ap[0].equals("-")) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i)[0].equals(ap[0]))
                    list.remove(i--);
            }
        }

        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[1].equals("-")) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i)[1].equals(ap[1]))
                    list.remove(i--);
            }
        }
        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[2].equals("-")) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i)[2].equals(ap[2]))
                    list.remove(i--);
            }
        }
        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[3].equals("-")) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i)[3].equals(ap[3]))
                    list.remove(i--);
            }
        }
        //System.out.println(Arrays.toString(noValid));
        //System.out.println(list.size());
        if (!ap[4].equals("-")) {
            for (int i = 0; i < list.size(); i++) {
                if (Integer.parseInt(list.get(i)[4]) < Integer.parseInt(ap[4]))
                    list.remove(i--);
            }
        }
        //System.out.println(list.size());

        return list.size();
    }
}
