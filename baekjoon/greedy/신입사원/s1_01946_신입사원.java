package greedy.신입사원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_01946_신입사원 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("greedy/신입사원/s1_01946.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] ranks = new int[N][2]; // 0: first, 1: second

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ranks, (o1, o2) -> o1[0] - o2[0]);
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(ranks[i]));
//            }

            int[] pre = new int[]{ranks[0][0], ranks[0][1]};
            int result = 1;
            for (int i = 1; i < N; i++) {
                int first = ranks[i][0];
                int second = ranks[i][1];

                if (second < pre[1]) {
                    pre[1] = second;
                    result += 1;
                }
            }

            System.out.println(result);
        }
    }
}

/**
 * 3100ms -> 860ms 줄이는 방법
 */
/*
import java.io.*;
        import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i <t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n];
            int min = n;
            for (int j = 0; j <n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int scoreA = Integer.parseInt(st.nextToken());
                int scoreB = Integer.parseInt(st.nextToken());
                score[scoreA-1] = scoreB-1;
            }
            int count = n;
            for (int j = 1; j <score.length; j++) {
                if(score[j-1]<min) min = score[j-1];
                if(score[j]>min) count--;
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
*/