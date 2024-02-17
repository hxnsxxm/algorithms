### 문제 링크
[백준/N과 M (1)](https://www.acmicpc.net/problem/15649)
  
<br>

### 문제

자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

<br> 

### 입력

첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

```agsl
3 1
```

<br>

### 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.  

```agsl
1
2
3
```

<br>

## 풀이

- 1부터 N까지 자연수 중에서 <b>중복 없이 M개</b>를 고른 수열

<b>Decision Space</b>  
- 길이가 M인 수열

### 구현 코드
```java
package backtracking.N과M1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N과M1 {

    static int N;
    static int M;
    static StringBuffer sb = new StringBuffer();
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/backtracking/N과M1/s3_15649.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        used = new boolean[N];
        bt(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bt(int depth) {
        //Decision space
        //1. 길이가 M인 수열
        if (depth == M) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i + 1;
                bt(depth + 1);
                used[i] = false;
            }
        }

    }
}
```