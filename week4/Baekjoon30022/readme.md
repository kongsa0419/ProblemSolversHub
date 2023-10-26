# (30022) 행사 준비
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/30022)
#
## 문제
동하와 지원이는 ANA 행사를 준비하고 있다. 행사를 위해 $N$종류의 물건이 한 개씩 필요하기 때문에 동하가 $A$개를, 지원이가 $B$개를 나눠서 준비하기로 했다.

근처에 있는 상점 1, 2에서 $N$종류의 물건을 모두 판매하고 있다. 같은 물건이라도 상점에서 판매하는 가격이 다를 수 있기 때문에 동하는 상점 1에서, 지원이는 상점 2에서 물건을 구입하려고 한다. 상점 1에서는 각각의 물건을 $p_1,p_2,\cdots ,p_N$원에 판매하고, 상점 2에서는 $q_1,q_2,\cdots ,q_N$원에 판매한다.

동하가 상점 1에서 $A$개의 물건을, 지원이가 상점 2에서 $B$개의 물건을 구입해서 $N$종류의 물건을 모두 구매하는 데 필요한 최소 비용을 구해보자.
#
## 입력
첫째 줄에 정수 $N(2\le N\le 100,000)$과 정수 $A,B(1\le A,B\leq N;A+B=N)$가 공백으로 구분되어 주어진다.

둘째 줄부터 $N$개의 줄에 정수 $p_i,q_i(1\le p_i,q_i\le 10^9)$가 공백으로 구분되어 주어진다. $p_i,q_i$는 상점 1, 2에서 $i$번째 물건을 판매하는 가격을 의미한다.
## 출력
상점 1에서 $A$개의 물건을, 상점 2에서 $B$개의 물건을 구입해서 $N$종류의 물건을 모두 구매하는 데 필요한 최소 비용을 출력한다.