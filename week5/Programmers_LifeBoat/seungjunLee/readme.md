# 풀이

- 투포인터

1. left와 right 두 개의 포인터를 생성.
    - left = 0
    - right = people 배열의 마지막 인덱스

2. people의 배열을 오름차순 정렬.

3. while문으로 left < right 인 동안 반복.
    - people[left] + people[right] > limit 경우 : people[right] 한 사람만 태우는 배가 필요하므로 answer++;로 카운트 right--;로 포인터를 옮김.
    - people[left] + people[right] <= limit 경우 : people[left]와 people[right] 두명을 태우는 배 -> answer++;로 카운트 left++; right--;로 포인터 옮김.
4. while문이 끝나면 left == right인 경우와 left > right인 두가지 경우 발생.
    - left == right : 나머지 한사람(people[right])을 태울 배가 필요하므로 answer++;
    - left > right : 모든 사람을 다 태웠으므로 answer을 카운트 하지않음.
5. answer를 return.