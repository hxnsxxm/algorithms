### 기본 구현

```java
int[] nums = {6, 2, 3, 1, 5, 4};

public static void main(String[]args){
    int goal = 4;

    Arrays.sort(nums);

    binary_search(goal);
}

public void binary_search(int goal) {
    int left = 0;
    int right = nums.length - 1;
    int mid;
    
    while (left <= right) {
        mid = (left + right)/2;
        int num = nums[mid];
        
        if (num == goal)
            // 찾음
        else if (num < goal)
            left = mid + 1;
        else
            right = mid - 1
    }
}
```

<br>

### 배열 내에 같은 값을 가진 원소들이 존재할 때 -> 최소 인덱스, 최대 인덱스 찾기

1. 최소 인덱스 -> `lower_bound`
2. 최대 인덱스 -> `upper_bound`

```java
class Main {
    int[] nums = {10, 10, 2, 5, 5, 3, 7, 10, 2};
    public static void main(String[] args) {
        int goal = 10;
        System.out.println(lower_bound(goal)); // 최소
        System.out.println(upper_bound(goal)); // 최대
    }
    
    public static int lower_bound(int goal) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while (left < right) {
            mid = (left + right) / 2;
            int num = nums[mid];
            
            if (num < goal)
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
    
    public static int upper_bound(int goal) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right)/2;
            int num = nums[mid];

            if (num <= goal) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left - 1; // !! 정확한 인덱스는 left 에서 -1 해야 함.
    }
}
```

<br>

### 예제 문제 : 백준/나무 자르기 `upper bound`
```java
static long bSearch() {
    long bottom = 0;
    long top = max + 1;
    long mid = 0;

    while (bottom < top) {
        mid = bottom + (top - bottom)/2;
        System.out.print(top + ", " + bottom + ", " + mid);
        long sum = 0;

        for (int h : trees) {
            if (h > mid)
                sum += h - mid;
        }
        System.out.println(" >> sum : " + sum);

        if (sum < M)
            top = mid;
        else
            bottom = mid + 1;
    }

    return bottom - 1;
}
```