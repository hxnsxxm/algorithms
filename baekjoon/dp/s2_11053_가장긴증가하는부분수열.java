import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s2_11053_가장긴증가하는부분수열 {

    static int N;
    static int[] numbers;
    static int[] tabular;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("dp/input/s2_11053.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        tabular = new int[N];
        numbers = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            tabular[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    tabular[i] = Math.max(tabular[i], tabular[j] + 1);
                }
            }
            max = Math.max(max, tabular[i]);
        }

        System.out.print(max);
    }
}
