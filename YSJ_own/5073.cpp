#include<iostream>
#include<stdlib.h>
#include<vector>
#include<algorithm>

using namespace std;
string triangle[] = {"Invalid", "Equilateral", "Isosceles", "Scalene"};
int p;
int solve(vector<int>& sides){
    //0. sides 정렬
    sort(sides.begin(), sides.end());
    //1. 삼각형 되는지 판단
    if(sides[2] >= sides[1]+sides[0]) {return 0;}
    //2. 삼각형 유형 판단
    if(sides[0]==sides[1] && sides[1]==sides[2]) return 1;
    else if (sides[0]==sides[1] || sides[0]==sides[2] || sides[1]==sides[2]) return 2;
    else return 3;
}
int main(void){
    int i=0;
    vector<int> ins(3);
    do{
        // scanf("%d%d%d", &ins[0], &ins[1], &ins[2]);
        cin >> ins[0] >> ins[1] >> ins[2];
        if(ins[0]==0 && ins[1]==0 && ins[2]==0) {return 0;}
        else cout << triangle[solve(ins)] << endl; 
    }while(1);
    return 0;
}