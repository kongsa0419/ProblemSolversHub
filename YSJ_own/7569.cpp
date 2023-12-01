//[solved] 왜 segfault????? 안 사라짐...
//===> Q에 아무것도 들어가지 않았을 경우가 예외 case임. Q.front()하니까 에러날 수 밖에

#include<iostream>
#include<queue>
#define SIZE 103
using namespace std;


int dir[6][3] = { // x,y,z
    {0,1,0}, {0,-1,0}, {1,0,0}, {-1,0,0}, {0,0,-1}, {0,0,1}
};

typedef struct point{
    int x,y,z,d;
}Point;

int X,Y,Z;
int unmat=0; //익지않은 토마토
int day=0;
int map[SIZE][SIZE][SIZE], ch[SIZE][SIZE][SIZE];
queue<Point> Q;


bool safeIndex(int x, int y, int z){
    if(x>=0 && x<X && y>=0 && y<Y && z>=0 && z<Z) return true;
    else return false;
}


//solution
// 토마토가 모두 익을 수 있는 상황이면 0, 그렇지 못하면 -1 출력
int solve(){
    if(unmat==0) {return day;}
    queue<Point> newQ;
    while(!Q.empty()){
        int x,y,z,d; //익은 토마토의 좌표
        x = Q.front().x;
        y = Q.front().y;
        z = Q.front().z; 
        d = Q.front().d; Q.pop();
        if(d!=day) {
            day = d;
            while(!newQ.empty()){
                Point a = newQ.front(); newQ.pop();
                map[a.z][a.y][a.x] = 1;
            } //비워줌
            // printmap();
        }
        for(int i=0; i<6; i++){
            if  (safeIndex(x+dir[i][0], y+dir[i][1], z+dir[i][2]) 
                    && ch[z+dir[i][2]][y+dir[i][1]][x+dir[i][0]] == 0
                    && map[z+dir[i][2]][y+dir[i][1]][x+dir[i][0]] == 0)
            {
                ch[z+dir[i][2]][y+dir[i][1]][x+dir[i][0]] = 1; //check
                newQ.push({x+dir[i][0], y+dir[i][1], z+dir[i][2], /*무시*/ d+1});
                Q.push({x+dir[i][0], y+dir[i][1], z+dir[i][2], d+1});
                unmat--;
                //if(unmat<0) {perror("unmatured tomato error"); exit(1);}
            }
        }
    }

    if(unmat==0) return day;
    // else if(unmat <0) {perror("unmatured tomato error"); return -100;}
    else return -1;
}

int main(void){
    cin >> X >> Y >> Z;
    int i,j,k;
    for(i=0;i<Z;i++){
        for(j=0; j<Y; j++){
            for(k=0;k<X;k++){
                cin >> map[i][j][k];
                if(map[i][j][k]==0) unmat++; // 덜 익은 토마토
                if(map[i][j][k]!=0) ch[i][j][k] = 1;
                if(map[i][j][k]==1) Q.push({k,j,i,0}); //익은 토마토의 좌표를 넣어줌
            }
        }
    }

    cout << solve() << endl;
    return 0;
}