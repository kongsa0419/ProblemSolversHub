# 풀이

### 생각의 흐름
해당 문제를 풀기 위해 저의 생각의 흐름은 다음과 같이 진행되었습니다.

1. main 함수에서 patty의 개수와 cheese의 개수를 입력 받는다.
2. make_burger 함수에서 치즈버거를 출력한다.

이 때 YES와 NO 여부는 patty와 cheese의 개수에 따라 결정되고,<br>
햄버거 출력 역시 재료 개수로 결정되므로 하나의 함수 make_burger에서 모든 것을 구현하였습니다.

### 치즈버거 출력
NO가 나오는 경우는 patty와 cheese의 개수만으로 결정이 됩니다.
1. cheese의 개수가 patty보다 많다면 NO가 출력됩니다.<br>
-> cheese 위아래로 patty가 있어야하므로 무조건 patty가 많아야 합니다.<br>
2. patty의 개수가 cheese의 2배보다 많아도 NO가 출력됩니다.<br>
-> cheese 위아래 patty를 모두 놓아도 2배가 최대입니다.<br>

YES일 때 나오는 경우는 patty와 cheese의 차이를 중요하게 생각했습니다.
1. patty - cheese는 치즈버거(burger)의 개수입니다.<br>
-> 하나의 치즈버거에서 patty와 cheese의 차이는 1이기 때문입니다.<br>
2. 이 때 patty / 남은 버거의 개수(patty-cheese) 를 사용해야합니다.<br>
2-1. patty(a)를 먼저 두고 시작합니다.<br>
2-2. patty / (patty-cheese) 를 소수점에서 올림처리하고 1을 빼준만큼 'ba'를 반복합니다.<br>
2-3. 이 때 올림처리를 하고 1을 빼주는 이유는 자연수일 때 상황을 포함시키기 위해서입니다.<br>
3. 치즈버거를 만든 후 남은 patty와 cheese의 개수를 업데이트합니다.

---

# 느낀점 및 수정해야될 사항

- YES가 되는 경우에 patty에 관한 이중 조건문을 걸었으면 더욱 편했을 것입니다.
- 햄버거의 개수는 상관없었기 때문에 굳이 math를 사용하지 않아도 되었다.