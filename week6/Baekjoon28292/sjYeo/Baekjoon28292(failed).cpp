// 개미수열 문제(FAILED ver.) (구현문제: 수열 등 *노가다(?)를 통해 패턴을 알아내어 푸는 문제)

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
#include<string> // 헤더파일 (string.h == cstring) 과 string은 다름
using namespace std;

// 개미 수열(sequence) 생성
string gen_num(const string& s){
    int len = s.length(); // NULL문자 제외한 문자개수
    int i,j,cnt;
    string ret = "";

    for(i=0; i<len; i++){
        j=i;
        cnt=1;
        for(; j+1<len && s[j+1]==s[i]; j++){ //j+1에서 인덱스체크하기 때문에 (s[j+1]==s[i]) 비교문은 안전함
            cnt++;
        }

        // s[i] = 'N' 형태의 ASCII문자임. 따라서 '0'을 빼줘야 우리가 원하는 (int)N이 됌.
        ret.append(to_string(s[i]-'0'));
        ret.append(to_string(cnt));
        i=j;
    }
    // cout <<"ret: " + ret << endl;
    // printf("ret: %s\n", ret.c_str());
    return ret;
}

int main(void){
    string init = "1";
    int N, res=-1;
    scanf("%d", &N);
    while(--N> 0){
        init = gen_num(init);
    }
    for(int i=0; i<init.length(); i++){
        if(init[i]-'0' > res) res = init[i]-'0';
    }
    printf("%d", res);
    return 0;
}