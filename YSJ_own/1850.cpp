#include<iostream>
#define int unsigned long long
using namespace std;

int gcd(int a, int b){
    return a%b==0 ? b: gcd(b,a%b);
}
int32_t main(void){
    int a,b;
    cin >> a >> b;
    int ret = ((a>b) ? gcd(a,b) : gcd(b,a));
    while(ret-->0){
        cout << "1";
    }
    return 0;
    
}