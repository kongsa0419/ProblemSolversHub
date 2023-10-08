def main() :
    # 입력
    N = int(input())
    
    present(N)
    
def present(N) :
    # N이 1일 때는 무조건 YES
    if N == 1 :
        print("YES\n1")
    # N이 2일 때는 무조건 NO
    elif N == 2 :
        print("NO")
    # N이 3이상일 때는 stack을 이용하여 푼다.
    else :
        # 숫자를 담을 리스트
        num_list = list()
        # stack으로 활용될 리스트
        result_list = list()
        # num_list에 숫자를 채워준다.
        for i in range(1, N+1) :
            num_list.append(i)
        # stack에 모든 숫자가 채워질 때 까지 반복
        while len(result_list) < N :
            for m in num_list[:] :
                # stack에 num_list의 숫자를 채운다
                result_list.append(m)
                num_list.remove(m)
                # stack안에 숫자의 총합이 소수라면
                if find_prime(sum(result_list)) == True :
                    # stack을 비워준다.
                    num_list.append(result_list.pop())
        # YES 및 숫자 출력
        print("YES")
        for i in result_list :
            print(i, end=' ')

# 소수를 찾는 함수
def find_prime(num) :
    # 2보다 클 때
    if num > 2 :
        # 2부터 num-1까지 모든 숫자로 나눴을 때
        for i in range(2, num) :
            # 나머지가 0이면 소수가 아니다.
            if num % i == 0 :
                return False
        # 검사 과정을 통과하면 소수이다.
        return True
    # 2이면 소수이다.
    elif num == 2 :
        return True
    # 0, 1은 소수가 아니다.
    return False

if __name__ =="__main__":
    main()