
- DP : 한 번 지나친 곳의 결과를 사용한다.  
- BT : 조건에 맞지 않는 곳은 무시한다.  
  
<br>

- 반복문으로만 구현 시 -> M 개수만큼 for문 만들어야 함 -> 재귀로 구현
- 재귀에서 빠져나오는 방법? -> Decision Space

<br>

### 참고 사항

1. 1부터 N까지 자연수 중에서 M개를 고른 수열   
  1-1. 중복 없이 (허용)  
  1-2. 중복 비허용  

#### 1부터 N까지 자연수 중에서 M개를 고른 수열 

<b>1-1. 중복 없이(허용)</b>  

```agsl
1 ~ 4 까지의 자연수로 길이가 2인 수열을 만드는 모든 경우

1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
```

```java
void bt(int depth) {
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
```

<b>1-1. 중복 비허용</b>  
```agsl
1 ~ 4 까지의 자연수로 길이가 2인 수열을 만드는 모든 경우

1 2
1 3
1 4
2 3
2 4
3 4
```

```java
void bt(int depth, int start) {
    //Decision space
    //1. 길이가 M인 수열
    if (depth == M) {
        for (int n : arr) {
            sb.append(n).append(" ");
        }
        sb.append("\n");
        return;
    }

    for (int i = start; i < N; i++) {
        if (!used[i]) {
            used[i] = true;
            arr[depth] = i + 1;
            bt(depth + 1, i + 1);
            used[i] = false;
        }
    }

}
```

