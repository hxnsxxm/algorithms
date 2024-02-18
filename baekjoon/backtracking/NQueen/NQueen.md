### 문제 링크
[백준/N-Queen](https://www.acmicpc.net/problem/9663)

<br>

### 문제

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

<br>

### 입력

첫째 줄에 N이 주어진다. (1 ≤ N < 15)

```java
8
```

<br>

### 출력

첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

```java
92
```

<br>

## 풀이

- 퀸 3개(N개) 놓기  
1\) 1번 퀸 -> 자리 잡음  
2\) 2번 퀸 -> 1번 퀸과 겹치면 안됨  
3\) 3번 퀸 -> 1, 2번 퀸과 겹치면 안됨  
...  
N) N번 퀸 -> 1 ~ N-1 번 퀸과 겹치면 안됨


- 겹치지 않는 조건  
  - 무조건 같은 행 or 열은 안됨  
  - 대각선 안됨

<br>

1. 퀸 개수에 따라 반복문 개수 달라짐 -> `재귀로 구현`
2. 조건 불만족 시 무시한다. -> `backtracking`
3. Decision space : `depth == N`

### 구현 코드
```java
package NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NQueen {

    static int N;
    static int result;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/backtracking/NQueen/g4_09663.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        queens = new int[N];

        bt(0);

        System.out.print(result);
    }

    static void bt(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queens[depth] = i;
            // 유효한 퀸만 놓고 다음 퀸 검사
            if (isValid(depth)) {
                bt(depth + 1);
            }
        }
    }

    static boolean isValid(int col) {
        // 1 ~ N-1 까지 유효성 검시
        for (int i = 0; i < col; i++) {
            if (queens[i] == queens[col]) {
                return false;
            } else if (Math.abs(i - col) == Math.abs(queens[i] - queens[col])) {
                return false;
            }
        }

        return true;
    }
}
```