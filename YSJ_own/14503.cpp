// [NOTE] 
// 로봇의 4방향 중, 한 곳이라도 청소할 수 있는 곳이 있다면, 무지성으로 반시계 방향으로 90도 회전이 먼저 이루어져야 합니다.
// 0: 청소 안 된 빈칸, 1: 벽

#include<iostream>
#include<queue>
#include<stack>
using namespace std;
int N,M, map[55][55];
// 북동남서
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};


bool safeIndex(int y, int x){
    return (y>=0 && x>=0 && y<N && x<M)?true:false;
}
void dfs(int r, int c, int d, int cnt){
    if(map[r][c]==0){
        map[r][c]=2; //flag
        cnt++;
    }
    for(int i=0; i<4; i++){
        int nd = (d+3-i)%4;
        int ny = r+dy[nd];
        int nx = c+dx[nd];
        if(safeIndex(ny,nx) && map[ny][nx]==0){
            dfs(ny, nx, nd, cnt);
        }
    }
    
    int od = (d+2)%4;
    int oy = r+dy[od];
    int ox = c+dx[od];
    if(map[oy][ox]==1){
        cout << cnt << endl;
        exit(0);
    }else{
        dfs(oy,ox,d,cnt);
    }
}

int main(void){
    int r,c,d,cnt=0;
    cin >> N >> M;
    cin >> r >> c >> d;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> map[i][j];
        }
    }
    dfs(r,c,d,cnt);
    return 0;
}