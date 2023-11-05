def main() :
    T = int(input())
    
    print_list = list()
    
    for _ in range(T) :
        a, b = map(int, input().split())
        print_list.append(earned_money(a, b))
        
    for i in range(len(print_list)) :
        print(print_list[i])
    
def earned_money(a, b) :
    total_money = 0
    if a == 0 :
        pass
    elif a == 1 :
        total_money += 5000000
    elif a <= 3 :
        total_money += 3000000
    elif a <= 6 :
        total_money += 2000000
    elif a <= 10 :
        total_money += 500000
    elif a <= 15  :
        total_money += 300000
    elif a <= 21 :
        total_money += 100000
    if b == 0:
        pass
    elif b == 1 :
        total_money += 5120000
    elif b <= 3 :
        total_money += 2560000
    elif b <= 7 :
        total_money += 1280000
    elif b <= 15 :
        total_money += 640000
    elif b <= 31 :
        total_money += 320000
    return total_money
        
if __name__ == "__main__" :
    main()