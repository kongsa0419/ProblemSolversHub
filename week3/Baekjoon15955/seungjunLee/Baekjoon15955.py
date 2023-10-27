import sys
sys.setrecursionlimit(10**6)
node = []


def make_edge(N, NList):

    x_sort = sorted(NList, key=lambda x : x[0])
    y_sort = sorted(NList, key=lambda x : x[1])
    x = [[x_sort[i][2], x_sort[i+1][2], x_sort[i+1][0] - x_sort[i][0]] for i in range(N-1)]
    y = [[y_sort[i][2], y_sort[i+1][2], y_sort[i+1][1] - y_sort[i][1]] for i in range(N-1)]

    x.extend(y)
    x.sort(key=lambda x : x[2])

    return x

def kruskal(node, edge, hp, start):
    for i in range(start, len(edge)):
        if edge[i][2] <= hp:
            union(edge[i][0], edge[i][1])
        else:
            node[0] = hp
            return i
        
    return len(edge)

def find(n):
    if node[n] == n:
        return n
    else:
        root = find(node[n])
        node[n] = root
        return root
    
def union(a, b):
    root_a = find(a)
    root_b = find(b)
    node[root_b] = root_a



def solve(N, Q, NList, QList):
    
    ansList = ['' for _ in range(Q)]
    edge = make_edge(N, NList)
    for i in range(N+1):
        node.append(i)
    check = kruskal(node, edge, 0 , 0)
    
    for start, end, hp, idx in QList:
        if node[0] == hp:
            if find(start) == find(end):
                ansList[idx] = 'YES'
            else:
                ansList[idx] = 'NO'
        else:
            check = kruskal(node, edge, hp, check)
            if find(start) == find(end):
                ansList[idx] = 'YES'
            else:
                ansList[idx] = 'NO'
    
    return ansList

def main():
    N, Q = map(int, input().split())
    NList = []
    for i in range(N):
        NList.append(list(map(int, sys.stdin.readline().split())))
        NList[i].append(i+1)

    QList = [list(map(int, sys.stdin.readline().split())) for _ in range(Q)]
    for i in range(Q):
        QList[i].append(i)
    

    QList.sort(key=lambda x :(x[2]))  
    ans = solve(N,Q,NList,QList)

    for i in ans:
        sys.stdout.write(i+'\n')
    

if __name__ == '__main__':
    main()