package 키패드누르기;

public class kakao_카카오인턴_키패드누르기 {
    int lh = 10;
    int rh = 11;

    int[][] pos = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 2}
    };

    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuffer sb = new StringBuffer();




        for (int number : numbers) {

            if (number == 1 || number == 4 || number == 7) {
                lh = number;
                sb.append("L");
            } else if (number == 3 || number == 6 || number == 9) {
                rh = number;
                sb.append("R");
            } else {
                if (comp(number, hand).equals("R")) {
                    rh = number;
                } else {
                    lh = number;
                }
                sb.append(comp(number, hand));
            }
        }

        return sb.toString();
    }

    String comp(int num, String hand) {
        int l = Math.abs(pos[num][0] - pos[lh][0]) + Math.abs(pos[num][1] - pos[lh][1]);
        int r = Math.abs(pos[num][0] - pos[rh][0]) + Math.abs(pos[num][1] - pos[rh][1]);

        if (l == r) {
            if (hand.equals("right"))
                return "R";
            return "L";
        } else if (l < r)
            return "L";
        return "R";
    }
}
