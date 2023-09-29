def main() :
    n, m = map(int, input().split())
    print (f(n,m,n+m))
    
def f(a,b,c) :
    result = 0
    if c == 0 :
        return 1
    else :
        for j in range(a+1) :
            for k in range(b+1) :
                if j + k == c :
                    result += 1
        return f(a,b,c-1) + result
    
if __name__ =="__main__":
    main()