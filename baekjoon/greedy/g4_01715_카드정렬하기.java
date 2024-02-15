import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g4_01715_카드정렬하기 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("greedy/input/g4_01715.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while (!queue.isEmpty()) {
            long num1 = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            long num2 = queue.poll();
            queue.add(num1 + num2);
            sum += num1 + num2;
        }

        System.out.print(sum);
    }
}
