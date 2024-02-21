
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