import sys

def solve(N, M, Reserv):
    res_state = [0 for _ in range(N+1)]
    for i in range(M):
        seat, start, end = Reserv[i]
        if res_state[seat] <= start:
            res_state[seat] = end
            sys.stdout.write('YES\n')
        else:
            sys.stdout.write('NO\n')
        

def main():
    N, M = map(int, sys.stdin.readline().split())
    Reserv = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
    solve(N, M, Reserv)

if __name__ == '__main__':
    main()