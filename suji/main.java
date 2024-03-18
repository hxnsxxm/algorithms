public class main {
    static int N = 4;
    static int[] arr = new int[N];
    static boolean[] used = new boolean[N];

    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        String str = "";
        //bt(0, str);
        //bt02(0);
        bt03(0, 0);
    }

    //중복 비허용
    static void bt03(int depth, int start) {
        if (depth == 2) {
            System.out.println(arr[0] + ", " + arr[1]);
            return;
        }

        for (int i = start; i < 4; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                bt03(depth + 1, i + 1);
                used[i] = false;
            }
        }
    }

    //중복 허용
    static void bt02(int depth) {
        if (depth == 2) {
            System.out.println(arr[0] + ", " + arr[1]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                bt02(depth + 1);
                used[i] = false;
            }
        }
    }

    //부분집합
    static void bt(int depth, String str) {
        if (depth == N) {
            System.out.println(str);
            return;
        }

        bt(depth + 1, str);
        bt(depth + 1, str + " " + (depth + 1));
    }
}
