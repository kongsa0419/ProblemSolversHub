def main() :
    # 양의 정수 n, m은 띄어쓰기로 구분
    patty, cheese = map(int, input().split())
    
    burger_size = make_burger(patty, cheese)
    print(burger_size)
    
def make_burger(patty, cheese) :
    if cheese >= patty :
        return patty * 2 - 1
    else :
        return cheese * 2 + 1
    
if __name__ == "__main__":
    main()