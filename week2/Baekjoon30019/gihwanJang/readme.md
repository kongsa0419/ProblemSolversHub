# 풀이

해당 문제는 예약가능 여부를 출력하는 구현에 해당 하는 문제입니다.  

입력에 대한 방번호, 시작 시간, 종료 시간에 대하여 저장할 수 있는 자료구조를 별도로 만들어 사용하였습니다.  
해당 자료구조에 대하여 n개의 예약들(reservations)은 아래와 같이 표현됩니다. 

- EX) 입력 예제2 n = 2, m = 4

|idx        |0 |1 |2 |3 |
|-----------|--|--|--|--|
|room number|1 |2 |1 |1 |
|start      |1 |2 |3 |5 |
|end        |4 |5 |7 |8 |

위의 테이블에 대하여 아래와 같은 현재까지의 마지막 방 예약(roomList) 유지합니다.

|room number    |1 |2 |
|---------------|--|--|
|reservation_idx|-1|-1|

이제 0~(n-1) 인덱스에 대하여 아래의 과정을 시행합니다.
1. 해당 reservation[i]의 room number 즉 roomList[reservation[i].roomNum]이 -1인경우
    - 예약이 가능 하므로 yes를 문자열에 추가하고 해당 값을 해당 인덱스로 바꿔줍니다.
    - string += "yes\n"
    - roomList[reservation[i].roomNum] = i
2. 1번의 경우가 아니고 reservation[roomList[reservation[i].roomNum]]의 end가 reservation[i]의 start보다 큰경우
    - 예약이 가능 하므로 yes를 문자열에 추가하고 해당 값을 해당 인덱스로 바꿔줍니다.
    - string += "yes\n"
    - roomList[reservation[i].roomNum] = i
3. 이외의 경우
    - 예약이 불가능 하므로 no를 문자열에 추가
    - string += "no\n"

위의 예제에 대하여 진행 과정은 아래와 같습니다.  

- i=0 -> string = "yes\n"

|room number    |1 |2 |
|---------------|--|--|
|reservation_idx|0 |-1|

- i=1 -> string = "yes\n yes\n"

|room number    |1 |2 |
|---------------|--|--|
|reservation_idx|0 |1 |

- i=2 -> string = "yes\n yes\n no\n"

|room number    |1 |2 |
|---------------|--|--|
|reservation_idx|0 |1 |

- i=3 -> string = "yes\n yes\n no\n yes\n"

|room number    |1 |2 |
|---------------|--|--|
|reservation_idx|3 |1 |