### 문제 링크
[백준/2xn 타일링](https://www.acmicpc.net/problem/11726)

### 문제

2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

### 입력

첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

```java
2
```

### 출력

첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

```java
2
```

## 풀이

DP 문제 풀이 순서

1. 주어진 문제의 optimal solution이 구조적으로 어떤 특징을 가지는지 분석한다.  
   1-1. ~하는 경우의 최솟값 -> `depth` 개수와 관련있음  
   1-2. ~하는 방법의 수 -> 마지막 노드 중 유효한(조건 만족) 노드의 개수
2. 재귀적인 형태로 optimal solution의 value를 정의한다.
3. (주로) Bottom-Up 방식으로 optimal solution의 value를 구한다.
4. (추가될 수 있음) 지금까지 계산된 정보를 바탕으로 optimal solution을 구한다.

### 참고 사항

- ~하는 방법의 수 -> 마지막 노드 중 유효한(조건 만족) 노드의 개수
- 10007을 나눈 수를 기록한다.

### 2. 재귀적인 형태로 optimal solution의 value를 정의한다.
```java
int count(int n) {
    if (n == 1)
        return 1;
    if (n == 2)
        return 2;

    return (count(n - 1) + count(n - 2)) % 10007;
}
```

### 3. (주로) Bottom-Up 방식으로 optimal solution의 value를 구한다.
```java
int count_bottom_up(int n) {
    int[] tabular = new int[1001];

    tabular[1] = 1;
    tabular[2] = 2;

    for (int i = 3; i <= n; i++) {
        tabular[i] = (tabular[i - 1] + tabular[i - 2]) % 10007;
    }

    return tabular[n];
}
```

### 구현 코드
```java
package _2xn타일링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2xn타일링 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                new FileReader("baekjoon/dp/_2xn타일링/s3_11726.txt")
        );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        //System.out.println(count(n));
        System.out.print(count_bottom_up(n));
    }

    static int count(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return (count(n - 1) + count(n - 2)) % 10007;
    }

    static int count_bottom_up(int n) {
        int[] tabular = new int[1001];

        tabular[1] = 1;
        tabular[2] = 2;

        for (int i = 3; i <= n; i++) {
            tabular[i] = (tabular[i - 1] + tabular[i - 2]) % 10007;
        }

        return tabular[n];
    }
}
```