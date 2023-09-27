# 풀이
정수쌍을 구하는 문제

- input으로 n, m 정수쌍을 만듦
- 전체 개수를 세줄 count 변수를 0으로 초기화
- 반복문으로 n+m+1만큼 반복시킴
    - count += func(n, m, i) 을 통해 전체 개수를 세줌

- 정수쌍을 계산해주는 func함수를 만듦
    - n, m, sum을 매개변수로 가짐
    - 2중 for문을 통해 정수쌍의 개수 pairCnt를 카운트함
    - pairCnt를 return 시켜줌