def solution(N, P, Q, R):
    for i in range(N):
        if P[i] == Q[i] == R[i]:
            P[i] = ''
            Q[i] = ''
            R[i] = ''


    P =' '.join(P).split()
    Q =' '.join(Q).split()
    R =' '.join(R).split()

    if len(P) < 1:
        return 'Hmm...'
    
    if P[0] != Q[0] != R[0] != P[0]:
        return 'HJS! HJS! HJS!'
    elif P[0] == R[0] != Q[0]:
        return 'Hmm...'

    elif P[0] == Q[0] != R[0]:
        for i in range(len(P)):
            if P[i] != Q[i]: 
                if P[i] == R[0] and Q[i] == Q[0]:
                    return 'Hmm...'
                else:
                    return 'HJS! HJS! HJS!'   
        return 'Hmm...'
        
    elif P[0] != Q[0] == R[0]:
        for i in range(len(P)):
            if Q[i] != R[i]:
                if R[i] == P[0] and Q[i] == Q[0]:
                    return 'Hmm...'
                else:
                    return 'HJS! HJS! HJS!'
        return 'Hmm...'
        
    else:
        return 'Hmm...'
            
            

def main():
    N = int(input())
    P = list(input())
    Q = list(input())
    R = list(input())

    print(solution(N,P,Q,R))
    
main()