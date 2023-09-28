# 풀이

해당 문제는 패티의 수 A와 치즈의 수 B에 대하여 (k+1 <= A) & (k <= B)를 만족하는 최대의 2k+1을 출력하는 문제입니다.  

그러므로 (A <= B), (A > B) 2가지의 경우로 나눌 수 있습니다. 

1. (A <= B)인 경우 k+1의 최대 값은 A가 될 수 있음으로 2A-1을 출력해 줍니다.
2. (A > B)인 경우 k의 최대 값은 B가 되고 2B+1를 출력해 줍니다.