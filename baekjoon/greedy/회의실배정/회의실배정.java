package 회의실배정;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {

    static int N;
    static Integer[][] times;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/회의실배정/s1_01931.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        times = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(times[i]));
//        }

        int pre_end = times[0][1];
        int result = 1;
        for (int i = 1; i < N; i++) {
            int start = times[i][0];
            int end = times[i][1];

            //System.out.println("pre_end : " + pre_end + ", start : " + start);

            if (start >= pre_end) {
                pre_end = end;
                result++;
            }
        }

        System.out.print(result);
    }
}
