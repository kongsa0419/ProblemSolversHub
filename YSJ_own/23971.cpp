#include<iostream>
using namespace std;
int main(void){
    int H,W,N,M, cnt=0;
    cin >> H >> W >> N >> M;
    
    int i,j;
    for(i=1; i<=H; i+=(N+1)){
        for(j=1; j<=W; j+=(M+1)){
            cnt++;
        }
    }
    cout << cnt;
    return 0;
}