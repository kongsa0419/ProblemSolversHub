import math          

def main() :
    # 입력
    patty, cheese = map(int, input().split())
    
    make_burger(patty, cheese)

def make_burger(patty, cheese) :
    if patty <= cheese :
        print("NO")
    elif patty > cheese * 2 :
        print("NO")
    else :
        print("YES")
        if patty - 1 == cheese :
            print("1\na", end='')
            for i in range(cheese) :
                print("ba", end='')
        else :
            burger = patty - cheese
            print(burger)
            for i in range(burger) :
                print("a", end='')
                repeat = math.ceil(patty / (patty - cheese)) - 1
                for j in range(repeat) :
                    print('ba', end='')
                patty -= repeat + 1
                cheese -= repeat
                print()
    
if __name__ =="__main__":
    main()