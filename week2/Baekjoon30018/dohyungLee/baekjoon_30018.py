def main() :
    # 입력
    N = int(input())
    origin_location = list(map(int, input().split()))
    new_location = list(map(int, input().split()))
    
    changed_bike = bike_count(N, origin_location, new_location)
    
    print(changed_bike)
    
# 자전거 개수 계산
def bike_count(N ,origin, new) :
    changed_bike = 0    # 옮긴 자전거 개수
    for i in range(N) :
        tmp = origin[i] - new[i]    # 대여 전/후 자전거 개수 차이 비교
        if tmp > 0 :
            changed_bike += tmp     # 그만큼 자전거가 옮겨졌으므로 더해주나
    return changed_bike             # 출력

if __name__ == "__main__":
    main()