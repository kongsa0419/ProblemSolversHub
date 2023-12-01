// https://www.acmicpc.net/problem/
//다익스트라 복습
// O(N^2) ==> O(NlogN)으로 시간을 줄임

#include<stdio.h>
#include<vector>
#include<queue>
#define MAX_INT 2147000000
#define x first
#define y second

using namespace std;

int main(void){
    struct cmp{
        bool operator()(pair<int,int> p1, pair<int,int> p2){
            return p1.y > p2.y; // 오름차순 (거리)
        }
    };
    int V,E,K,a,b,c,j;
    scanf("%d%d%d", &V,&E,&K);
    vector<vector<pair<int,int>>> map(V+3, vector<pair<int,int>>());
    for(j=0; j<E; j++){
        scanf("%d %d %d", &a, &b, &c);
        map[a].push_back({b,c});
    }
    vector<int> ch(V+3, 0), dist(V+3, MAX_INT);
    priority_queue<pair<int,int>, vector<pair<int,int>> , cmp> pq;
    pq.push({K,0});
    dist[K] = 0;
    while(!pq.empty()) { // 
        int v = pq.top().x; //가장 가까운 근처 노드
        int w = pq.top().y; // 시작점~노드까지의 최소거리
        pq.pop();
        if(ch[v]) continue;
        ch[v] = 1;
        for(j=0; j<map[v].size(); j++){ //모든 인접 노드
            int vv = map[v][j].x;
            int ww = map[v][j].y;
            if(ch[vv]==0 && dist[vv] > dist[v] + ww){ ///기존 거리보다 짧은 경로가 발견되면
                dist[vv] = dist[v] + ww;
                pq.push({vv, dist[vv]});
            }
        }
    }
    
    for(j=1; j<=V; j++){
        if(dist[j] == MAX_INT) printf("INF\n");
        else printf("%d\n", dist[j]);
    }

    return 0;
}