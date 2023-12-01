#include<iostream>
using namespace std;
int main(void){
    int n, route=1, bound=1, plus=6;
    cin >> n;
    
    while(bound < n){
        route++;
        bound += plus;
        plus += 6;
    }
    cout << route<< endl;
    return 0;
}