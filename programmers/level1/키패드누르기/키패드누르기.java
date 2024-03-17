package 키패드누르기;

public class 키패드누르기 {
    private static int[][] pad = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 2}
    };
    private static int lHand = 10;
    private static int rHand = 11;

    public String solution(int[] numbers, String hand) {
        String answer = "";

        for (int n : numbers) {
            String h = selectHand(n, hand);

            if (h.equals("L"))
                lHand = n;
            else
                rHand = n;

            answer += h;
        }

        return answer;
    }

    private String selectHand(int n, String h) {
        String hand;

        if (n == 1 || n == 4 || n == 7) {
            hand = "L";
        } else if (n == 3 || n == 6 || n == 9) {
            hand = "R";
        } else {
            int l = Math.abs(pad[n][0] - pad[lHand][0]) + Math.abs(pad[n][1] - pad[lHand][1]);
            int r = Math.abs(pad[n][0] - pad[rHand][0]) + Math.abs(pad[n][1] - pad[rHand][1]);

            if (l < r)
                hand = "L";
            else if (l > r)
                hand = "R";
            else
                hand = h.equals("left") ? "L" : "R";
        }

        return hand;
    }
}
