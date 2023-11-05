# 풀이

- 구현

1. 첫 째줄에 N, M (nm배열), 둘 째줄에 로봇의 위치와 바라보는 방향(robot배열), 셋 째줄부터 map의 모양(mapArr배열)을 입력받음.
2. 로봇의 위치로부터 동서남북 4방향에 대한 좌표 checkX, checkY를 북,서,남,동 순으로 변수를 만듦.
3. checkAround 함수를 통해 주위 4방향에 청소를 안한 부분이 있는지 체크
    - 먼저 see = robot[2]로 변수를 만들고 반복문을 통해 4번 반복
    - see = (1 + see) % 4 로(반시계 90도 회전) 회전함.
    - mapArr[checkY[see]][checkX[see]] 로 그 위치에 청소가 안되어있으면 robot[2] = see로 갱신 후 return true
    - 반복문 동안 청소안한 부분이 발견되지 않으면 return false

4. 조건문으로 checkAround가 true이면 로봇 전진
    - 전진 후 cleanCurrent로 현재 위치를 청소하고 count+1 시킴
5. checkAround가 false 일 경우 후진
    - 후진 하려는 방향에 벽이 있을 경우 카운트를 return 시킴
6. 이 방법으로 후진했을 때 벽이 마주칠 때 까지 반복문 진행.