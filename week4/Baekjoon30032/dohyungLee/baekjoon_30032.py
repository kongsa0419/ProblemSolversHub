def main() :
    # N과 D 입력받음
    N, D = map(int, input().split())
    
    # 알파벳을 저장할 배열
    alphabet_list = list()
    
    # 입력을 통해 배열에 저장
    for _ in range(N) :
        alphabet_list.append(input())
    
    # 뒤집은 결과 출력
    reverse_alphabet(D, alphabet_list)

# 알파벳을 뒤집는 함수
def reverse_alphabet(D, list) :
    # 상하 전환 딕셔너리
    updown_reverse = {'d':'q', 'b':'p', 'q':'d', 'p':'b'}
    
    # 좌우 전환 딕셔너리
    leftright_reverse = {'d':'b', 'b':'d', 'q':'p', 'p':'q'}
    
    # 상하 전환 될 때
    if D == 1 :
        # 상하 전환 딕셔너리 사용하여 출력
        for i in list :
            for k in i :
                print(updown_reverse[k], end='')
            print() # 위의 모든 글자를 붙혀서 출력하고 마지막에 줄바꿈
    
    # 좌우 전환 될 때
    elif D == 2 :
        # 좌우 전환 딕셔너리 사용하여 출력
        for i in list :
            for k in i :
                print(leftright_reverse[k], end = '')
            print() # 위의 모든 글자를 붙혀서 출력하고 마지막에 줄바꿈
            
if __name__ == "__main__" :
    main()