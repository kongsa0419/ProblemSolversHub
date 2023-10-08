import sys

def A(a):
    if a == 0:
        return 0
    
    for i in range(1, 7):
        if a - i <= 0:
            return i
        a -= i
        
    return 0

def B(b):
    if b == 0:
        return 0
    
    i = 1
    for j in range(1, 6):
        if b - i <= 0:
            return j
        b -= i
        i *= 2
    
    return 0



def solve(T, TList):

    Reward = []
    AReward = [0, 5000000, 3000000, 2000000, 500000, 300000, 100000]
    BReward = [0, 5120000, 2560000, 1280000, 640000, 320000]

    for a, b in TList:
        Reward.append(AReward[A(a)]+BReward[B(b)])

    for i in range(T):
        sys.stdout.write(str(Reward[i]) + '\n')



def main():
    T = int(input())
    TList = []

    for i in range(T):
        TList.append(list(map(int, sys.stdin.readline().split())))

    solve(T, TList)

if __name__ == '__main__':
    main()