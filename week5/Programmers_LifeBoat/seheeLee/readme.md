### 풀이 
이 문제는 투포인터 문제로 단순히 정렬해서 앞에서 부터 채우면 틀린 답이 된다. 

문제를 해결하기 위해서는 최대한 보트의 제한값을 꽉채워 보내야한다. 그렇게 하기 위해서는 
<br>
작은 사람 한명 (순서대로) + 맨 뒤 무거운 순으로 (뒤에서 앞으로) <= limit 을 만족하면 된다. 

조건을 만족하면(둘다 태울 수 있으면) 포인트를 각각 low,high로 설정하여 low++ , high--로 범위를 줄여주면 되고,

조건을 만족하지 못하면(만약 함께 태울 수 없다면) high-- 만 해주면 된다. high 사람은 무거워서 무조건 한 보트로 보내야한다는 뜻이므로 지나친다. 

<br>

이 문제를 풀기위해서 처음에 구현한 방법은 다음과 같다.<br>

```
while(lowIndex <= highIndex){
        if(people[lowIndex] + people[highIndex] <= limit ){
        lowIndex++;
        highIndex--;
    }
    else{highIndex--;}
    answer++;
}
```
하지만 기환 스터디원이 알려준 방법으로 코드를 간결하게 해결할 수 있었다. 조건이 있고,공통적으로 ++ ,-- 해야한다면 다음 형태에 반복문을 고려해보자! 
<br>

```
for(int lowIndex = 0,highIndex = people.length-1; lowIndex <= highIndex  ;highIndex--,
    answer++){
    if(people[lowIndex] + people[highIndex] <= limit)lowIndex++;
}
```