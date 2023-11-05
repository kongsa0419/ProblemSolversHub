import sys

def main() :
    # 강의실 수, 예약 수 입력받음
    classes, requests = map(int, input().split())
    
    # 예약 명단을 차례대로 입력
    request_lists = []
    for _ in range(requests) :
        request_lists.append(list(map(int,sys.stdin.readline().split())))
    
    check_request(classes, request_lists)
    
# 예약 확인 여부
def check_request(classes, request_lists) :
    # 이전 예약이 끝나는 시간 배열
    end_times = [0] * classes
    # 예약 순서대로 체크 (빠른 시간부터 시작하므로)
    for i in range(len(request_lists)) :
        # 이전 예약이 끝나는 시간 > 다음 예약의 시작 시간
        if end_times[request_lists[i][0] - 1] > request_lists[i][1] :
            # 예약이 확정되지 않음
            print("NO")
        # 다음 예약의 시간 > 이전 예약이 끝나는 시간
        else :
            # 예약 확정
            print("YES")
            # 새로운 예약이 끝나는 시간이 등록됨
            end_times[request_lists[i][0] - 1] = request_lists[i][2]
        
if __name__ == "__main__":
    main()