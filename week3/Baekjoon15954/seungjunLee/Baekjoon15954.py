import sys

def STD(s, K, NList):
    std = 0
    m = 0
    for i in range(s, s+K):
        m += NList[i]
    

    m /= K
    for i in range(s, s+K):
        std += (NList[i]-m)**2

    std /= K

    return std**(1/2)


def solve(N, K, NList):
    minSTD = float('inf')

    for j in range(K, N+1):
        for i in range(N-j+1):
            tmp = STD(i, j, NList)

            if minSTD > tmp:
                minSTD = tmp
        
    return minSTD


def main():
    N, K = map(int, input().split())
    NList = list(map(int, sys.stdin.readline().split()))

    print(solve(N, K, NList))

if __name__ == '__main__':
    main()