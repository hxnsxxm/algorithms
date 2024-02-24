package level2.이모티콘할인행사;

public class 이모티콘할인행사 {
    int[] rates = {10, 20, 30, 40};
    int user_len;
    int emo_len;
    int[] select;
    int[][] user;
    int[] emo;
    //List<int[]> list = new ArrayList<>();
    int max_plus = 0;
    int max_amount = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        user_len = users.length;
        emo_len = emoticons.length;

        user = users;
        emo = emoticons;

        select = new int[emo_len];

        bt(0);

        // for (int[] l : list) {
        //     System.out.println("(" + l[0] + ", " + l[1] + ")");
        // }

        // Collections.sort(list, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         if (o1[0] == o2[0])
        //             return o2[1] - o1[1];
        //         return o2[0] - o1[0];
        //     }
        // });


        // for (int[] l : list) {
        //     System.out.println(l[0] + ", " + l[1]);
        // }

        //answer = list.get(0);
        answer = new int[]{max_plus, max_amount};

        return answer;
    }

    void bt (int depth) {
        if (depth == emo_len) {
            //System.out.println(Arrays.toString(select));

//             for (int r = 0; r < emo_len; r++) {
//                 int rate = select[r];

//                 for (int u = 0; u < user_len; u++) {
//                     int limit_rate = user[u][0];
//                     int limit_total = user[u][1];

//                     int total_amount = 0;

//                     if (rate < limit_rate)
//                         continue;
//                 }
//             }
            int plus = 0;
            int amount = 0;

            for (int u = 0; u < user_len; u++) {
                int limit_rate = user[u][0];
                int limit_total = user[u][1];

                int total_amount = 0;

                for (int r = 0; r < emo_len; r++) {
                    int rate = select[r];

                    if (rate < limit_rate)
                        continue;

                    total_amount += emo[r] * (100 - rate) / 100;
                }

                if (total_amount >= limit_total) { // 플러스 가입
                    plus += 1;
                } else { // 돈 주고 삼
                    amount += total_amount;
                }
            }

            if (max_plus < plus) {
                max_plus = plus;
                max_amount = amount;
            } else if (max_plus == plus) {
                max_amount = Math.max(max_amount, amount);
            }

            //list.add(new int[]{plus, amount});

            return;
        }

        for (int i = 0; i < 4; i++) {
            select[depth] = rates[i];
            bt(depth + 1);
        }
    }
}
