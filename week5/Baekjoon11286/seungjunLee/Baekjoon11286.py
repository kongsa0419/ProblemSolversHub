import sys
from queue import PriorityQueue


def solution(NList):
    ansList = []
    que = PriorityQueue()

    for info in NList:
        if info == 0:
            if que.empty():
                ansList.append(0)
            else:
                ans, sign = que.get()
                ansList.append(ans*sign)
        
        else:
            if info < 0:
                que.put((-info, -1))
            else:
                que.put((info, 1))

    
    for ans in ansList:
        sys.stdout.write(str(ans)+'\n')



def main():
    N = int(sys.stdin.readline())
    NList = [int(sys.stdin.readline()) for _ in range(N)]

    solution(NList)


if __name__ == '__main__':
    main()