#include<iostream>
int main(void){
    int n;
    std::cin >> n;
    for(int i=n; i>=1; i--){
        int k=i;
        while(k-->0){
            std::cout << "*";
        }
        std::cout<<std::endl;
    }
    return 0;
}