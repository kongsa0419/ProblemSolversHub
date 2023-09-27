# 풀이
문제 유형 : 다이나믹 프로그래밍, 비트마스크<br>

- 헤로의 삼각형 넓이 공식 : sqrt(p*(p-a)*(p-b)*(p-c))
    - a, b, c : 세 변의 길이
    - p = (a+b+c)/2
    - a < b < c 일 때, a + b > c 를 만족해야함

- input 값 : 울타리 갯수 N, N개의 각 울타리 길이 nList
- nList는 sort()와 reverse()를 활용하여 내림차순 정렬
- areaList
    - areaList = [[bit0, area0], [bit1, area1] .... ]
    - 3중첩 for문과 조건문을 활용하여 3개의 울타리로 삼각형을 만들 수 있는 모든 경우의 수를 조사하여 울타리의 번호를 비트 값으로 저장.
        - 예시로 총 6개의 울타리 중 1,2,3번 울타리를 사용할 경우
        - 0b111000 으로 저장
        - 삼각형의 조건을 만족할경우 비트 연산자를 활용하여 [bit, area] 부분 중 bit에 저장
    
    - 함수 areaOfH(a,b,c)를 활용하여 넓이값을 계산하여 [bit, area]부분 중 area에 저장

- DP
    - DP 리스트는 0.0으로 초기화 하는데 그 크기는 input으로 받은 N을 활용하여 1 << N+1 크기로 초기화
        - 예시로 N을 6으로 입력받으면 DP의 크기는 int(0b1000000) = 64 
    - DP[bit] = area
        - 반복문을 활용하여 DP[areaList[i][0]] = areaList[i][1]

- DP를 모두 설정하였으면 다이나믹 프로그래밍을 활용하여 값을 갱신함
- 반복문 1중첩
    - for i in range(len(DP)): DP의 크기(bit)만큼 반복
    - 만약 DP[i]의 크기가 0이 아니면 다음 반복문 진행
- 반복문 2중첩
    - for bit, area in areaList: areaList를 반복하여 bit와 area를 가져옴
    - if i & bit == 0: 울타리 사용이 겹치지 않으면
    - DP[i|bit] = max(DP[i|bit], DP[i]+area) -> 점화식
        - 울타리로 삼각형을 만드는 넓이의 합 최댓값

- return으로 DP리스트의 최댓값을 반환.
    