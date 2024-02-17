
DP 문제 풀이 순서

1. 주어진 문제의 optimal solution이 구조적으로 어떤 특징을 가지는지 분석한다.
2. 재귀적인 형태로 optimal solution의 value를 정의한다.
3. (주로) Bottom-Up 방식으로 optimal solution의 value를 구한다.
4. (추가될 수 있음) 지금까지 계산된 정보를 바탕으로 optimal solution을 구한다.


### 참고 사항

1\) ~하는 경우의 최솟값 -> `depth` 개수와 관련있음
  - 연산을 사용하는 횟수의 최솟값

2\) ~하는 방법의 수 -> 마지막 노드 중 유효한(조건 만족) 노드의 개수
  - n을 1, 2, 3의 합으로 나타내는 방법의 수