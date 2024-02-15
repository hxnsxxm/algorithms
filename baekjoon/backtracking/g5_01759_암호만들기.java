import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_01759_암호만들기 {

    static int L;
    static int C;
    static char[] str;
    static char[] code;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("backtracking/input/g5_01759.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        str = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            str[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(str);

        bt(0, 0);
    }

    static void bt(int depth, int idx) {
        if (depth == L) {
            if (isValid()) {
                System.out.println(code);
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            code[depth] = str[i];
            bt(depth + 1, i + 1);
        }
    }

    static boolean isValid() {
        int nVowel = 0;
        int nConsonant = 0;

        for (char c : code) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                nVowel++;
            else
                nConsonant++;
        }

        if (nVowel >= 1 && nConsonant >= 2)
            return true;
        return false;
    }
}
