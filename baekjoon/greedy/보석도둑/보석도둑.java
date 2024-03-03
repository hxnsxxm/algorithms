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

public class 보석도둑 {

    static int N;
    static int K;
    static long[][] jews;
    static long[] bags;
    static long result;

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
            jews[i][0] = Long.parseLong(st.nextToken());
            jews[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(jews, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] == o2[0])
                    return (int)(o2[1] - o1[1]);
                return (int)(o1[0] - o2[0]);
            }
        });

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(jews[i]));
//        }

        for (int i = 0; i < K; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jews[j][0] <= bags[i]) {
                pq.add(jews[j++][1]);
            }

            if (!pq.isEmpty())
                result += pq.poll();
        }

        System.out.println(result);
    }
}
