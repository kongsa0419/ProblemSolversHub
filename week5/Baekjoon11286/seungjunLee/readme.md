# 풀이

- 자료구조, 힙

1. 자료구조 힙을 이용한 문제
2. N 과 N개의 NList를 받음.
3. NList != 0 일 경우
    - 우선순위큐 내장 라이브러리로 만든 que를 이용하여 값을 입력해줌
    - NList 값이 음수일 경우 : que.put(-info, -1)
    - NList 값이 양수일 경우 : que.put(info, 1)
        - heapq -> heappush -> shiftdown 에서 완전 트리 형태 최소값을 루트로 보낼 때 비교연산을 진행하는데 절대값으로 info값이 같으면 튜플의 다음 -1과 1을 비교하여 음수인 -1이 루트에 가깝게 배치됨.
4. NList == 0 일 때, 
    - que가 empty이면 0을 출력
    - que에 값이 존재할 경우 ans, sign = que.get() 을 받아옴
        - ans는 info의 절대값, sign은 부호
    - ansList에 저장
5. ansList 출력