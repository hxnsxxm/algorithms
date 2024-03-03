package level2.양궁대회;

public class 양궁대회 {
    int N;
    int[] apeach;
    int[] result = new int[11];
    int max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        int[] answer = {-1};

        N = n;
        apeach = info;

        int[] arrows = new int[11];
        bt(0, 0, arrows);

        if (max == Integer.MIN_VALUE)
            return new int[]{-1};

        return result;
    }

    void bt(int depth, int cnt, int[] arrows) {
        if (cnt > N)
            return;
        if (cnt == N || depth == 11) {
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
        bt(depth + 1, cnt + arrows[depth], arrows.clone());

        //미획득
        if (depth == 10)
            arrows[depth] = N - cnt;
        else
            arrows[depth] = 0;
        bt(depth + 1, cnt + arrows[depth], arrows.clone());
    }

    int score(int[] arrows) {
        int apeach_score = 0;
        int rion_score = 0;

        for (int i = 0; i <= 10; i++) {
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

    void switch_score(int[] arrows) {
        for (int i = 10; i >= 0; i--) {
            if (arrows[i] > result[i]) {
                result = arrows.clone();
                break;
            } else if (arrows[i] < result[i])
                break;
        }
    }
}
