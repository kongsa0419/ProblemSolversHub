### 풀이
---
### 📄 1단계 문제 분석하기
---
- 2가지 조건을 순서로 정렬해서 하나씩 빼면된다. 
- 우선순위(정렬)을 할수 있는 우선순위 큐 사용했다. 
<br>

### 🤘 2단계 손으로 풀기
---
생략

### 👀 3단계 code 분석 
---
1. compareTo 정의  
compareTo를 구현하는 것은 자료구조를 선언하면서 람다함수를 쓰면 더욱 간결하게 정의할 수 있다. o1,o2를 매개변수를 정의하고 앞에 값이 더 크면 오름차순으로 정의되고 더 작으면 내림차순으로 정의하게 되므로 o1-o2 가 정석(오름차순)이다. 

```
static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
        else{ return Math.abs(o1) - Math.abs(o2);}
    });
```

그 외에는 조건에 맞춰서 Queue에서 poll()하여 꺼내 출력하면 된다.

<br>
---

### 피드백 👩‍🏫
문제는 간단하나 람다함수 사용법을 더욱 익혀두는 것이 좋을 것 같다. 
친구가 피드백<br>
1. 라인 수를 줄이는 것보다 중복을 피하는 것이 더욱 좋다.
```
//X
if(a && b)
if(a && c)
//O
if(a){
    if(b)
    if(c) 
}
```

2. !는 지양
```
if(!Queue.isEmpty()) A
else B

if(Queue.isEmpty()) B
else A

```