def main() :
    # 입력
    N, K = map(int, input().split())
    
    # 지목 정보 입력
    pick_list = []
    for _ in range(N) :
        pick_list.append(int(input()))
    
    # 출력
    print(the_game_of_death(K, pick_list))

# 더 게임 오브 데스        
def the_game_of_death(K, list) :
    visited = [False] * len(list)   # 방문 리스트
    turn = 0                        # 차례 (0번부터 시작)
    trial = 1                       # 시도
    
    # 똑같은 사람을 거치면 무한반복하므로 탈출
    while visited[turn] == False :
        visited[turn] = True        # 방문 여부 표시
        turn = list[turn]           # 그 다음 차례 지목
        
        # 보성이가 지목되면 횟수 출력
        if turn == K :
            return trial
        
        # 횟수 추가
        trial += 1
    return -1                       # 보성이가 지목되지 않으면 -1

if __name__ == "__main__":
    main()