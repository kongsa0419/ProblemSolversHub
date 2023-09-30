def solve(N, a, b):
    count = 0
    for i in range(N):
        if a[i] > b[i]:
            count += a[i] - b[i]
            
    return count

def main():
    N = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    print(solve(N, a, b)) 
    
if __name__ == '__main__':
    main()