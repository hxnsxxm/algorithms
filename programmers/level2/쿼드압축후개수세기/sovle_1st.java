package level2.쿼드압축후개수세기;

public class sovle_1st {
    class Solution {
        int len;
        boolean[][] zip;
        int[] answer;

        public int[] solution(int[][] arr) {
            answer = new int[2];

            len = arr.length;
            int n = 0;
            zip = new boolean[len][len];
            for (; Math.pow(2, n) < len; n++);

            for (int i = 0; i<= n; i++) {
                int t = (int)Math.pow(2, i);
                int offset = len / t;
                for (int sr = 0; sr < t; sr++) {
                    for (int sc = 0; sc < t; sc++) {
                        //System.out.println("offset:" + offset + ", offset * sr:" + (offset * sr) + ", offset * sc:" + offset * sc);
                        if (zip[offset * sr][offset * sc])
                            continue;
                        if (isInvalid(arr, offset, sr, sc))
                            continue;
                        check(arr, offset, sr, sc);
                        answer[arr[offset * sr][offset * sc]] += 1;
                        //System.out.println("offset * sr:" + offset * sr + ", offset * sc:" + offset * sc + " >> " + arr[offset * sr][offset * sc]);
                    }
                }
            }

            return answer;
        }

        boolean isInvalid(int[][] arr, int offset, int sr, int sc) {
            int tmp = arr[offset * sr][offset * sc];

            for (int r = offset * sr; r < offset * (sr + 1); r++) {
                for (int c = offset * sc; c < offset * (sc + 1); c++) {
                    if ((tmp ^ arr[r][c]) == 1)
                        return true;
                }
            }

            return false;
        }

        void check(int[][] arr, int offset, int sr, int sc) {
            for (int r = offset * sr; r < offset * (sr + 1); r++) {
                for (int c = offset * sc; c < offset * (sc + 1); c++) {
                    zip[r][c] = true;
                }
            }
        }
    }
}
