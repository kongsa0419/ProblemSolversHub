#include<iostream>
#include<queue>

#define SIZE 104
using namespace std;

typedef struct point_3d{
    int x,y,z,d;
};
int dx[6] = {1,-1,0,0,0,0};
int dy[6] = {0,0,1,-1,0,0};
int dz[6] = {0,0,0,0,1,-1};

int X,Y,Z, unmat{0};
int map[SIZE][SIZE][SIZE], ch[SIZE][SIZE][SIZE];
queue<point_3d> Q;

bool safeIndex(int z, int y, int x){
    if(z>=0 && z<Z && y>=0 && y<Y && z>=0 && z<Z) return true;
    else return false;
}

int solve(); // 토마토가 익을때까지 최소 며칠이 걸리는지 계산해서 출력
int main(void){
    cin >> X >> Y >> Z;
    for(int i=0; i<Z; i++){
        for(int j=0; j<Y; j++){
            for(int k=0; k<X; k++){
                cin >> map[i][j][k];
                if(map[i][j][k]==0) unmat++; //덜 익은
                else ch[i][j][k] = 1; //무시
                if(map[i][j][k]==1) Q.push({k,j,i,0}); // 다 익은
            }
        }
    }
    cout << solve() << endl;
    return 0;
}

int solve()
{
    if(unmat==0) return 0;
    
    while(!Q.empty())
    {
        int x,y,z,d;
        x = Q.front().x;
        y = Q.front().y;
        z = Q.front().z;
        d = Q.front().d; Q.pop();

    }
}