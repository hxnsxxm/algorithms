package greedy.보석도둑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class solve_2nd {

    static int N;
    static int K;
    static long[][] jews;
    static long[] bags;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/보석도둑/input.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jews = new long[N][2];
        bags = new long[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());

            jews[i] = new long[]{m, v};
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jews, (n1, n2) -> {
            if (n1[0] == n2[0])
                return (int)(n2[1] - n1[1]);
            return (int)(n1[0] - n2[0]);
        });
//        Arrays.sort(jews, new Comparator<long[]>() {
//            @Override
//            public int compare(long[] n1, long[] n2) {
//                if (n1[0] == n2[0])
//                    return (int)(n2[1] - n1[1]);
//                return (int)(n1[0] - n2[0]);
//            }
//        });

        Arrays.sort(bags);

        int result = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jews[j][0] <= bags[i]) {
                pq.add(jews[j++][1]);
            }

            if (!pq.isEmpty())
                result += pq.poll();
        }
        //안되는 방법
//        for (long b : bags) {
//            for (long[] j : jews) {
//                if (j[0] <= b) {
//                    pq.add(j[1]);
//                }
//            }
//
//            result += pq.poll();
//        }
//
//        for (int i = 0, j = 0; i < K; j++) {
//            if (jews[j][0] <= bags[i])
//                pq.add(jews[j][1]);
//            else {
//                result += pq.poll();
//                i++;
//            }
//        }

        System.out.println(result);
    }
}
