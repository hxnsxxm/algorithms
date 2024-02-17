
DP 문제 풀이 순서

1. 주어진 문제의 optimal solution이 구조적으로 어떤 특징을 가지는지 분석한다.  
  1-1. ~하는 경우의 최솟값 -> `depth` 개수와 관련있음  
  1-2. ~하는 방법의 수 -> 마지막 노드 중 유효한(조건 만족) 노드의 개수
2. 재귀적인 형태로 optimal solution의 value를 정의한다.
3. (주로) Bottom-Up 방식으로 optimal solution의 value를 구한다.
4. (추가될 수 있음) 지금까지 계산된 정보를 바탕으로 optimal solution을 구한다.

<br>

### 참고 사항

#### ~하는 경우의 최솟값 -> `depth` 개수와 관련있음
  - 연산을 사용하는 횟수의 최솟값
```java
/**
 * 재귀적으로 구현
 */
static int operate(int x) {
    if (x == 1)
        return 0;

    if (x%3 == 0) {
        return Math.min(operate(x/3), operate(x - 1)) + 1;
    }

    if (x%2 == 0) {
        return Math.min(operate(x/2), operate(x - 1)) + 1;
    }

    if (x%3 == 0 && x%2 == 0)
        return Math.min(operate(x/2), operate(x/3)) + 1;

    return operate(x - 1) + 1;
}

/**
 * Dynamic Programming 구현 : bottom-up 방식
 */
int operate_bottom_up(int x) {
    if (x == 1)
        return 0;

    int[] tabular = new int[x + 1];
    tabular[1] = 0;
    if (x >= 2) tabular[2] = 1;
    if (x >= 3) tabular[3] = 1;

    for (int i = 4; i <= x; i++) {
        if (i%3 == 0)
            tabular[i] = Math.min(tabular[i/3], tabular[i - 1]) + 1;
        if (i%2 == 0)
            tabular[i] = Math.min(tabular[i/2], tabular[i - 1]) + 1;
        if (i % 3 == 0 && i % 2 == 0)
            tabular[i] = Math.min(tabular[i/3], tabular[i/2]) + 1;
        if (i % 3 != 0 && i % 2 != 0)
            tabular[i] = tabular[i - 1] + 1;
        }

    return tabular[x];
}
```

#### ~하는 방법의 수 -> 마지막 노드 중 유효한(조건 만족) 노드의 개수
  - n을 1, 2, 3의 합으로 나타내는 방법의 수
```java
/**
 * 재귀적으로 구현
 */
int count(int n) {
    if (n < 0)
        return 0;
    if (n == 0)
        return 1;

    return count(n - 1) + count(n - 2) + count(n - 3);
}

/**
 * Dynamic Programming 구현 : bottom-up 방식
 */
int countWays(int n) {
    int[] dp = new int[n + 1];

    // 초기값 설정
    dp[0] = 1;

    // 다이나믹 프로그래밍을 이용하여 각 경우의 수 계산
    for (int i = 1; i <= n; i++) {
        if (i - 1 >= 0) {
            dp[i] += dp[i - 1];
        }
        if (i - 2 >= 0) {
            dp[i] += dp[i - 2];
        }
        if (i - 3 >= 0) {
            dp[i] += dp[i - 3];
        }
    }

    return dp[n];
}

/**
 * Dynamic Programming 구현 : bottom-up 방식
 */
int count_bottom_up (int n) {
    int[] tabular = new int[11];

    tabular[1] = 1;
    tabular[2] = 2;
    tabular[3] = 4;

    for (int i = 4; i <= n; i++) {
        tabular[i] = tabular[i - 1] + tabular[i - 2] + tabular[i - 3];
    }

    return tabular[n];
}

```