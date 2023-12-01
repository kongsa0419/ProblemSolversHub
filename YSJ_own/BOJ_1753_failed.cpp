// https://www.acmicpc.net/problem/
//다익스트라 복습
// O(N^2) 시간초과
#include<stdio.h>
#include<vector>
#define MAX_INT 2147000000
#define x first
#define y second

using namespace std;

int main(void){
    int V,E,K,a,b,c,i,j, min;
    scanf("%d%d%d", &V,&E,&K);
    vector<vector<pair<int,int>>> map(V+3, vector<pair<int,int>>());
    for(i=0; i<E; i++){
        scanf("%d %d %d", &a, &b, &c);
        map[a].push_back({b,c});
    }
    vector<int> ch(V+3, 0), dist(V+3, MAX_INT);
    
    dist[K] = 0;
    for(i=1; i<=V; i++){ // O(N^2) : 4 10e8 : 400 000 000 (4억) 보통 1억 = 1초
        min = 0;
        for(j=1; j<=V; j++){
            if(ch[j]==0 && dist[min] > dist[j]){
                min = j;
            }
        }
        ch[min] = 1;
        for(j=0; j<map[min].size(); j++){
            int v = map[min][j].x;
            int w = map[min][j].y;
            if(dist[v] > dist[min] + w){
                dist[v] = dist[min] + w;
            }
        }
    }

    for(i=1; i<=V; i++){
        if(dist[i] == MAX_INT) printf("INF\n");
        else printf("%d\n", dist[i]);
    }

    return 0;
}