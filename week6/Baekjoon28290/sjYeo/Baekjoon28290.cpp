#include<iostream>
#include<string>
#include<cstring>

using namespace std;

// size=6
static char* typings[] = {
    "fdsajkl;", // 1 
    "jkl;fdsa", // 1
    "asdf;lkj", // 2
    ";lkjasdf", // 2
    "asdfjkl;", // 3
    ";lkjfdsa"  // 4
};

int main(void){
    char u_in[9];
    //iostream, 마지막 NULL문자를 제외한 n-1개의 문자를 읽어와 str 배열에 저장
    cin.getline(u_in, sizeof(u_in));
    int i;
    for(i=0; i<6; i++){
        if(strcmp(typings[i], u_in)==0){ //문자열이 같으면
            switch(i){
                case 0:
                case 1: {printf("in-out\n"); return 0;}
                case 2: 
                case 3: {printf("out-in\n"); return 0;}
                case 4: {printf("stairs\n"); return 0;}
                case 5: {printf("reverse\n"); return 0;}
            }
        }
    }
    printf("molu\n");
    return 0;
}