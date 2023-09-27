def areaOfH(a,b,c):
    s = (a + b + c)/2
    return (s*(s-a)*(s-b)*(s-c))**0.5


def solution(N, nList):
    nList.sort()
    nList.reverse()
    areaList = []
    DP = [0.0]*(1 << (N+1))

    for i in range(N):
        for j in range(i+1, N):
            for k in range(j+1, N):
                if nList[i] < nList[j] + nList[k]:
                    bit1 = 1
                    bit2 = 1
                    bit3 = 1
                    bit1 = bit1 << N-i-1
                    bit2 = bit2 << N-j-1
                    bit3 = bit3 << N-k-1
                    areaList.append([(bit1 | bit2 | bit3) , areaOfH(nList[i], nList[j], nList[k])])


    for i in range(len(areaList)):
        DP[areaList[i][0]] = areaList[i][1]

    for i in range(len(DP)):
        if DP[i] != 0:
            for bit, area in areaList:
                if i & bit == 0:
                    DP[i|bit] = max(DP[i|bit], DP[i]+area)
                
    return max(DP)
    
def main():
    N = int(input())
    nList = list(map(int, input().split()))

    print(solution(N, nList))
    
    
if __name__ =="__main__":
    main()