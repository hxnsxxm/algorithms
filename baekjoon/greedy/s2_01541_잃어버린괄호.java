import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class s2_01541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("greedy/input/s2_01541.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;


        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;

        while (subtraction.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.print(sum);
    }
}
