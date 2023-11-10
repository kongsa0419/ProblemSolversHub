// 거듭제곱의 자리수 문제
#include<iostream>
#include<stdio.h> //file I/O
#include <cmath>

// c++에서는 (not C) '로 큰 수를 가독성있게 표현 가능
#define A_MAX 100// 10'000
#define B_MAX 100// 10'000'000  

using namespace std;

//calculate digits in a number
int digit(unsigned long long num){
    int cnt=0;
    while(num>0){
        cnt++;
        num /= 10;
    }
    return cnt;
}

int main(void){
    FILE* pFile;
    unsigned long long cal;
    pFile = fopen("log.txt", "w");
    if(pFile == NULL){
        perror("Error opening log file\n");
        return 1;
    }else{
        puts("FILE OPEN SUCCESS");
    }


    int i,j, a, b, res, d;
    for(i=0; i<=A_MAX; i++)
    {
        if(i==0){
            for(j=1; j<=B_MAX; j++){
                fprintf(pFile, "%-8d", j);
            }
            fprintf(pFile, "\n");
            continue;
        }
        fprintf(pFile, "\n[i:%d]\n", i);
        for(j=1; j<=B_MAX; j++){
            cal = (unsigned long long)pow(i,j);
            d = digit(cal);
            fprintf(pFile, "%-8d", d);
        }
        fprintf(pFile, "\n");
    }

    fclose(pFile);
    return 0;
}
