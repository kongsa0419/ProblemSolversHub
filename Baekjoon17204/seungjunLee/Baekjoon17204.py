def solution(N, K, NPointOut):
    pointout = 0
    m = 0
    for _ in range(N):
        pointout = NPointOut[pointout]
        m += 1
        if K == pointout:
            return m
    return -1
    
def main():
    N, K = map(int, input().split())
    NPointOut = []
    for _ in range(N):
        NPointOut.append(int(input()))

    print(solution(N,K,NPointOut))

main()