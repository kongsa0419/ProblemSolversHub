import sys

def squareNoNo(n, mobius):
    p = 0
    for i in range(1, int(n ** 0.5) + 1):
        p += mobius[i] * (n // (i * i))
    return p

def solution(k):
    l, r = 0, 2000000000
    mobius = [0] * 1000001
    mobius[1] = 1
    for i in range(1, 1000001):
        if mobius[i]:
            for j in range(i * 2, 1000001, i):
                mobius[j] -= mobius[i]
                
    while l < r - 1:
        mid = (l + r) // 2
        if squareNoNo(mid, mobius) < k:
            l = mid
        else:
            r = mid
    return r

def main():
    k = int(sys.stdin.readline())
    print(solution(k))
    
if __name__ == "__main__":
    main()