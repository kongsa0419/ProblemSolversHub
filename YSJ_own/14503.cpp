// [NOTE] 
// 로봇의 4방향 중, 한 곳이라도 청소할 수 있는 곳이 있다면, 무지성으로 반시계 방향으로 90도 회전이 먼저 이루어져야 합니다.

#include<iostream>
#include<queue>
#include<stack>
using namespace std;
int N,M,ret=0, map[55][55], r,c,d;
// direction= 북동남서
int dx[] = {0,1,0,-1};
int dy[] = {-1,0,1,0};

typedef struct pos{
    int r,c,dir;
}Pos;

bool safeIndex(int y, int x){
    return (y>=0 && y<N && x>=0 && x<M) ? true : false;
}

// 로봇이 멈출때까지 청소한 블록 수를 ret에 반영
void solve(stack<pos>& S){
    while(!S.empty()){
        auto a = S.top();
        S.pop();
        if(map[a.r][a.c]==0){ //1
            map[a.r][a.c]=2;
            ret++;
        }
        bool cleanable = false;
        for(int i=0; i<4; i++){
            int nd = (a.dir+3-i)%4;
            int ny = a.r + dy[nd];
            int nx = a.c + dx[nd];
            if(safeIndex(ny,nx) && map[ny][nx]==0) {
                cleanable = true;
                S.push({ny,nx,nd});
                solve(S);
            }
        }
        int odir = (a.dir+2)%4;
        int oy = a.r + dy[odir];
        int ox = a.c + dx[odir];
        if(map[oy][ox]!=1){ //
            S.push({oy,ox,a.dir});
            solve(S);
        }
        if(!cleanable && map[oy][ox]==1) {
            cout << ret << endl;
            exit(0); //프로그램 강제 종료
        }
    }
}

int main(void){
    cin >> N >> M;
    cin >> r >> c >> d; //d : 북동남서
    stack<pos> S;
    S.push({r,c,d});
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> map[i][j];
        }
    }
    solve(S);
    // cout << ret << endl;
    return 0;
}