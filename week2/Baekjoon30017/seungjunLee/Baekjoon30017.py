def main():
    A, B = map(int, input().split())
    if A > B:
        print(B*2 + 1)
    elif A <= B:
        print(A*2 - 1)
    
if __name__ == '__main__' :
    main()