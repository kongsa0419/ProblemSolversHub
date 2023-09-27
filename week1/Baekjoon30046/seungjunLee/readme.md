# 풀이

문자열, 전수조사 문제

1. P, Q, R의 문자열을 리스트로 변환시킴.
2. 반복문을 통해 같은 열에 있는 문자가 P, Q, R 모두 동일하면 그 열의 문자들은 제거함.
3. 제거하고 남은 문자열의 크기가 0이면 'Hmm...'을 return함. 1보다 클 경우는 함수를 계속 실행.
4. 경우의 수는 4가지.
- P[0], Q[0], R[0]이 모두 다를 경우
    - P < Q < R 순으로 1, 2, 3을 대입하면 성립하므로 'HJS! HJS! HJS!'를 return

- P[0]과 R[0]는 동일하고 Q[0]는 다를 경우
    - P와 R이 동일하면 P > Q 이거나 Q > R 인 상황이 발생하므로 'Hmm...'을 return

- P[0]과 Q[0]는 동일하고 R[0]는 다를 경우
    - len(P) 까지 반복문을 돌려서 P[i] != Q[i]가 나올 때까지 반복 시키는데 반복문이 끝난다면 계속 동일한 값이므로 성립이 될수 없어서 'Hmm...'을 return.
    - P[i] != Q[i]인 부분이 나온다면 조건문을 통해 P[i] == R[0] and Q[i] == Q[0]이면 'Hmm...' return, 나머지는 모두 성립되므로 나머지는 'HSJ! ....'를 return.

- Q[0]과 R[0]는 동일하고 P[0]는 다를 경우
    - len(P) 까지 반복문을 돌려서 Q[i] != R[i]가 나올 때까지 반복 시키는데 반복문이 끝난다면 계속 동일한 값이므로 성립이 될수 없어서 'Hmm...'을 return.
    - Q[i] != R[i]인 부분이 나온다면 조건문을 통해 R[i] == P[0] and Q[i] == Q[0]이면 'Hmm...' return, 나머지는 모두 성립되므로 나머지는 'HSJ! ....'를 return.