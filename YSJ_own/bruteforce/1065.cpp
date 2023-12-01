#include<iostream>
using namespace std;

int N;
bool is_han(int x){
    if(x>=1 && x<=99) return true; //수학적 특성

    bool ret = true;
    int d1, d10, gap; //1의자리수와 10의자리수
    d1  = x%10;
    d10 = (x%100)/10;
    gap = d1- d10;
    do{
        x /= 10;
        d1  = x%10;
        d10 = (x%100)/10;
        if(d10 == 0 && x<10) {
            break; // 100의자리 수에서 등차가 0인 수열은 등차수열일 수 없지
        }
        
        if(gap == d1-d10){
            gap = d1-d10; //update
        }else{
            ret = false;
        }
    }while(ret);

    return ret;
}

int main(void) {
    scanf("%d", &N);
    int cnt=0;
    for(int i=1; i<=N; i++){
        if(is_han(i)) cnt++;
    }
    printf("%d", cnt);
    return 0;
}