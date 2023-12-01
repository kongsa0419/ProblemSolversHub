//Brute Force
#include<iostream>
#include<climits>
#include<vector>
#include<stack>
using namespace std;

int N, map[25][25];
int i,j,k,ret=INT_MAX, lim;

void calc(const vector<int>& l, const vector<int>& r){
    int sum =0;
    for(i=0; i<l.size(); i++){
        for(j=0; j<l.size(); j++){
            sum += map[l[i]][l[j]]; // if(i==j) map[i][j] = 0; 이라 예외처리 필요없음
        }
    }

    for(i=0; i<r.size(); i++){
        for(j=0; j<r.size(); j++){
            sum -= map[r[i]][r[j]];
        }
    }
    ret = min(ret, abs(sum));
    // printf("ret: %d\n", ret);
}

// 팀능력치의 차이가 최소일 때의 값 ret을 구하는 함수 (DFS)
// 매 solve가 호출될 때 vector가 복사됨.
// 만약 call by reference 쓰려면 vector<int>&로 올려야함 ==> 물론 dfs에는 해당 안됌
void solve(int index, vector<int> l, vector<int> r){
    // printf("l_addr::%p \t r_addr::%p\n");
    if(l.size()>N/2 || r.size()>N/2) return;
    if(index == N) {calc(l, r); return;}
    l.emplace_back(index);
    solve(index+1, l, r);
    l.pop_back();
    r.emplace_back(index);
    solve(index+1, l, r);
    // r.pop_back();
}

int main(void){
    scanf("%d", &N);
    for(i=0; i<N; i++){
        for(j=0; j<N; j++){
            scanf("%d" , &map[i][j]);
        }
    }
    solve(0, {}, {});
    printf("%d", ret); //최소차이값 출력
    return 0;
}