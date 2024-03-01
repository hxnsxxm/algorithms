package greedy.카드정렬하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드정렬하기 {

    static int N;
    static PriorityQueue<Integer> pQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/greedy/카드정렬하기/g4_01715.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pQueue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pQueue.size() >= 2) {
            int first = pQueue.poll();
            int second = pQueue.poll();

            result += first + second;
            pQueue.add(first + second);
        }

        System.out.println(result);

//        System.out.println(pQueue);
//
//        while (!pQueue.isEmpty()) {
//            System.out.print(pQueue.poll() + " ");
//        }
    }
}
