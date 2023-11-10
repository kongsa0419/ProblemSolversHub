// 개미수열 문제 (구현문제: 수열 등 *노가다(?)를 통해 패턴을 알아내어 푸는 문제)

// 초깃값 "1"을 가지고 N번동안 개미수열을 뽑아낸 결과 res
// char res[]의 모든 자리수(digit) 중 가장 큰 값을 출력

/** [string in C++]
 * string은 끝에 NULL문자를 가지지 않는 c++에서 사용하는 새로운 자료형임.
 * string.h 또는 cstring 에서 사용하는 strcmp(char* ,char*)등의 함수를 사용하지 않고 str.compare(string) 등의 함수를 사용함.
 * cstring보다 훨씬 다양하고 유용한 함수들을 제공함(중요)
 * 
 * cout<< 으로 출력할때와 printf("%s")로 출력할때가 달랐음.      
        printf("%s", str); 이 아니라
        c++ string 헤더는 printf("%s", s.c_str()); 형식으로 출력해줘야함.
*/

#include<iostream>
using namespace std;

int main(void){
    int ret [6] ={0,1,1,2,2,2}; // 구현 문제: 직접 수작업으로 패턴을 분석하여 실행속도를 단축시키는 문제
    int N, res=-1;
    scanf("%d", &N);
    res = (N > 5)? (3):(ret[N]);
    printf("%d", res);
    return 0;
}