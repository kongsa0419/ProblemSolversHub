// 자릿수 (수학 문제)

/**
     * unsigned int = %u
     * long         = %ld       ==> (at least more than 'int')
     * U_long       = %lu       
     * long long    = %lld       ==> (at least more than 8 Byte)
     * U_long long  = %llu
     * short        = %hd
     * 
     * [부동소수점은 ]
     * float        = %f        ==> 1.1f 식으로 선언해야 double과 구별
     * double       = %lf
     * long double  = %Lf       ==> (usually 80bit, at least more than 8 Byte)
*/

#include<iostream>
#include<cmath>
using namespace std;

int main(void){
    int a,b;
    long double log_res; //long double = at least 8 Byte Float ("%Lf")
    unsigned long long res = 1;
    cin >> a >> b;
    
    // log10(base=a , exponent=b) ==> b* log10(a)
    log_res = b * log10(a);
    res += floor(log_res);
    printf("%llu", res);
    return 0;
}