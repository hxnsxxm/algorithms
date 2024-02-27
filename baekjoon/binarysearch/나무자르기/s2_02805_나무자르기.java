package binarysearch.나무자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s2_02805_나무자르기 {

    static int N;
    static int M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("binarysearch/나무자르기/s2_02805.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i])
                max = trees[i];
        }

        System.out.println(bs(max));
    }

    static int bs(int n) {
        int min = 0;
        int max = n;

        while (min < max) {
            int mid = (min + max)/2;
            long sum = 0;
            for (int tree : trees) {
                if (tree - mid > 0)
                    sum += tree - mid;
            }

            if (sum < M)
                max = mid;
            else if (sum >= M)
                min = mid + 1;
        }

        return min - 1;
    }
}
