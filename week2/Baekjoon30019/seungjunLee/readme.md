# 풀이

- 테이블을 활용하는 문제

1. N, M, Reserv를 입력받음
2. table을 N+1 크기로 0 초기화
3. 반복문을 M만큼 돌려서 각 예약의 seat, start, end를 받아옴.
4. table 인덱스를 활용하여 res_state[seat] 의 값을 가져옴
    - 그 값은 seat 자리의 예약 end값이 저장되어 있음
5. res_state[seat]과 받은 start를 조건문을 통해 비교함.
6. 만약 상태 테이블에서 가져온 end값이 start보다 크면 그대로 두고 보다 작으면 Reserv에서 가져온 end값으로 상태 테이블을 갱신시켜줌
7. 조건문을 통해 확인한 값으로 사용 가능 여부를 YES, NO로 출력해줌.