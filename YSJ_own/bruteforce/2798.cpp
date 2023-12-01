//BFS ==>queue
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int N,M;
int main(void){
    scanf("%d%d", &N, &M);
    vector<int> v(N+4);
    int sum=-1, tmp;
    for(int i=0; i<N; i++)
    {
        scanf("%d", &v[i]);
    }


    for(int i=0; i<N; i++)
    {
        for(int j=0; j<N; j++)
        {
            if(j==i) continue;
            for(int k=0; k<N; k++)
            {
                if(k==i || k==j) continue;
                tmp = v[i]+v[k]+v[j];
                if(sum<tmp && tmp<=M) sum = tmp;
            }
        }
    }
    printf("%d\n", sum);
    return 0;
}