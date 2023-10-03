import sys

def solve(A, B):
    if B < A <= B*2:
        sys.stdout.write("YES\n")
        sub = A - B
        sys.stdout.write(str(sub)+'\n')
        for _ in range(sub-1):
            sys.stdout.write('aba\n')
        sys.stdout.write('a')
        for _ in range(B-sub+1):
            sys.stdout.write('ba')

    else:
        print('NO')
    

def main():
    A, B = map(int, sys.stdin.readline().split())
    solve(A, B)


if __name__ == '__main__':
    main()