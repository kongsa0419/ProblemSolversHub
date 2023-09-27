def func(n,m,sum):
    pairCnt = 0
    for i in range(n+1):
        for j in range(m+1):
            if sum == i+j:
                pairCnt += 1
    return pairCnt        
    
def solve(n, m):
    count = 0
    for i in range(n+m+1):
        count += func(n,m,i)
    return count

def main():
    n, m = map(int, input().split())
    print(solve(n,m))

if __name__ == '__main__':
    main()