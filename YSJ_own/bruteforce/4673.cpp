#include<iostream>
using namespace std;
#define SIZE 10'005
int ch[SIZE];

int gen_num(int x){
    // generator
    // x + sum_digits_of_x
    int ret=x;
    while(x>0){
        ret += (x%10);
        x /= 10;
    }
    // printf("x의 geNNUm= %d\n",ret);
    return ret;
}
int main(void){
    for(int i=1; i<=10'000; i++){
        if(ch[i]==0) {
            printf("%d\n",i); // self number출력
            int j=i;
            while(j<=10'000){
                ch[j] = 1;
                j = gen_num(j);
            }
            // puts("");
        }
    }
    return 0;
}