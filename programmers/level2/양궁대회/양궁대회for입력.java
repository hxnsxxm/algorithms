package level2.양궁대회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 양궁대회for입력 {

    static int N;
    static int[] apeach;
    static int[] result = new int[11];
    static int limit;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("programmers/level2/양궁대회/input.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        apeach = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            apeach[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(apeach));

        int[] arrows = new int[11];
        bt(0, 0, 0, arrows);

        if (max == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(Arrays.toString(result));
    }

    static void bt(int depth, int cnt, int start, int[] arrows) {
        if (cnt > N)
            return;
        if (cnt == N || depth == 11) {
//            if (limit++ <= 50)
//                System.out.println("cnt: " + cnt + ", " + Arrays.toString(arrows));
            int diff = score(arrows);

            if (diff <= 0)
                return;
            else if (max == diff)
                switch_score(arrows);
            else if (max < diff) {
                result = arrows.clone();
                max = diff;
            }

            return;
        }

        //획득
        if (depth == 10)
            arrows[depth] = N - cnt;
        else
            arrows[depth] = apeach[depth] + 1;
        bt(depth + 1, cnt + arrows[depth], depth + 1, arrows.clone());

        //미획득
        if (depth == 10)
            arrows[depth] = N - cnt;
        else
            arrows[depth] = 0;
        bt(depth + 1, cnt + arrows[depth], depth + 1, arrows.clone());



//        for (int i = start; i < 10; i--) {
//            //획득
//            arrows[i] = apeach[i] + 1;
//            bt(depth + 1, cnt + arrows[i], i + 1, arrows);
//
//            //미획득
//            if (i == 9)
//                arrows[i] = N - cnt;
//            else
//                arrows[i] = 0;
//            bt(depth + 1, cnt + arrows[i], i + 1, arrows);
//        }
    }

    static int score(int[] arrows) {
        int apeach_score = 0;
        int rion_score = 0;

        for (int i = 0; i < 10; i++) {
            if (apeach[i] == 0 && arrows[i] == 0)
                continue;

            int score = 10 - i;
            if (apeach[i] >= arrows[i])
                apeach_score += score;
            else
                rion_score += score;
        }

        return rion_score - apeach_score;
    }

    static void switch_score(int[] arrows) {
        for (int i = 10; i >= 0; i--) {
            if (arrows[i] > result[i]) {
                result = arrows.clone();
                break;
            } else if (arrows[i] < result[i])
                break;
        }
    }
}
