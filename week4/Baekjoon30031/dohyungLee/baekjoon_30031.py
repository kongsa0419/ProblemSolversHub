def main() :
    # N 입력
    N = int(input())
    
    # 가로를 저장할 배열
    width_list = list()
    
    # N 개의 줄의 가로, 세로 중 가로만 배열에 저장받는다.
    for _ in range(N) :
        width_list.append(list(map(int, input().split()))[0])
        
    print(sum_money(width_list))

# 지폐의 총액 구하는 함수
def sum_money(width_list) :
    # 지폐의 총액을 0으로 초기화
    total_money = 0
    
    # 가로 배열을 배열에서 꺼낸다
    for i in width_list :
        # 136mm -> 1,000원
        if i == 136 :
            total_money += 1000
            
        # 142mm -> 5,000원
        elif i == 142 :
            total_money += 5000
            
        # 148mm -> 10,000원
        elif i == 148 :
            total_money += 10000
            
        # 154mm -> 50,000원
        elif i == 154 :
            total_money += 50000
    
    # 지폐의 총합 반환
    return total_money
    
if __name__ == "__main__" :
    main()