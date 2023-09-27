import sys

def find(Gi, table):
    if table[Gi] == Gi:
        return Gi
    table[Gi] = find(table[Gi], table)
    return table[Gi]
    

def union(p1, p2, table):
    p1_root = find(p1, table)
    p2_root = find(p2, table)

    if p1_root == p2_root:
        return
    table[p1_root] = p2_root

def solution(G, P, Gi):
    table = [i for i in range(G+1)]
    
    for i in range(P):
        if find(Gi[i], table) == 0:
            return i
        union(Gi[i], find(Gi[i], table)-1, table)
    return P
            

def main():
    G = int(sys.stdin.readline())
    P = int(sys.stdin.readline())
    Gi = [None for _ in range(P)]
    for i in range(P):
        Gi[i] = int(sys.stdin.readline())

    print(solution(G, P, Gi))

main()


"""
#Before

def union(Gi, table):
    if find(table[Gi], table) == 0:
        return False
    else:
        if find(Gi, table) == Gi:
            table[Gi] = Gi-1
        else:
            x = find(Gi, table) 
            y = find(find(Gi, table)-1, table)
            table[x] = y
        
        return True
        

def solution(G, P, Gi):
    count = 0
    table = [i for i in range(G+1)]
    
    for _ in range(P):
        if union(Gi.pop(0), table):
            count += 1
        else:
            return count
    return count
"""