import sys

def solve(N):
    if N == 1:
        print('YES')
        print('1')
    elif N == 2:
        print('NO')
    else:
        print('YES')
        sys.stdout.write('1 3 2')
        for i in range(4, N+1):
            sys.stdout.write(' ' + str(i))

def main():
    N = int(sys.stdin.readline())
    solve(N)

if __name__ == '__main__':
    main()