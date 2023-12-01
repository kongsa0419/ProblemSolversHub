//BFS
#include<iostream>
#include<queue>
using namespace std;
typedef struct data{
    int num, turn;
}Data;

int main(void){
    int n, winner=-1;
    cin >> n;
    queue<Data> q;
    q.push({n,0});
    while(!q.empty())
    {
        auto& d = q.front();
        q.pop();
        cout << "d.turn=" << d.turn << ", d.num=" << d.num << endl;
        if(d.num - 1 == 0 || d.num - 3 == 0) {winner = d.turn + 1; break;}
        if(d.num -3 > 0) q.push({d.num-3, d.turn+1});
        if(d.num -1 > 0) q.push({d.num-1, d.turn+1});
    }
    winner%2==0 ? cout<<"CY" : cout<<"SK";
    return 0;
}