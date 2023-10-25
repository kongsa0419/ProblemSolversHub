### 풀이

- 첫번째 시도:모든 값을 숫자로 정렬한다. 한 줄로 정렬해서 작은 순서대로 고르되, 이미 고른 Index라면 제외, Count를 세서 최대 선택횟수 파악

원인: 한 줄로 정렬하면 반복문의 길이가 round*2 가 되므로 시간초과 

----
<br>

- 풀이: 해당 인덱스 별로 A상점 B상점 차이를 계산하고 차이가 큰 순서대로 정렬하여 더한다. 

- 배운점 : 기환이 코드를 확인해보니 Compator를 재정의 하지 않아도 클래스 내에서 Comparable를 구현하고 재정의하여 사용가능하다.

```
class Price implements Comparable<Price> {
    int p, q;

    @Override
    public int compareTo(Price o) {
        return Math.abs(o.p - o.q) - Math.abs(p - q);
    }
}
```
