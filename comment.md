
## 문자열
#### String - 문자열 정렬
```java
String str = "HELLO WORLD";

char[] chars = str.toCharArray();
Arrays.sort(chars);
String sorted = new String(chars);
```

<br>

#### String - 문자열 추출
```java
String str = "HELLOWORLD";

String new = str.substring(1, 5);
System.out.println(new); // out: "ELLO";
```
- `str.substring(1, 5)` : 1 ~ 4 까지 추출됨  

<br>

#### String - 문자열 변환
```java
String str = "()";

String trans = str.replaceAll("\\(", "t");
```
- "("나 ")"를 변환하려면 "\\(", "\\)" 로 기입해야 함.

<br>

## ArrayList
#### ArrayList 깊은 복사
```java
List<Integer> list = new ArrayList<>();

list.add(1);
list.add(3);
list.add(4);

List<Integer> copy = new ArrayList<>(list);
```

<br>

#### ArrayList 기본 문법
```java
List<Integer> list = new ArrayList<>();

list.add(1);     // {1}

list.set(0, 10); // 해당 인덱스의 값 변경, {10}

list.remove(0);  // 해당 인덱스의 값 삭제, {}
```

<br>

## 정렬
#### `new Comparator<>(){}`를 사용하여 내림차순 구현
```java
Arrays.sort(coins, new Comparator<Integer>(){
    @Override
    public int compare(Integer n, Integer m) {
        return m - n;
    }
});
```