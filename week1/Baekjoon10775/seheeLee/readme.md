## 풀이 

알고리즘 : Union find

1. 각 게이트는 자기 자신으로 만듭니다. 

<img width="397" alt="image" src="https://github.com/gihwanJang/ProblemSolversHub/assets/91319157/2b4334f5-491b-4607-9c38-710d8668fa95">
<br>
편의 상 게이트는 0번부터로 지정하겠습니다. 
<br>
그리고, 많은 비행기를 넣기 위해서는 범위에 내림차순부터 도킹을 시도해야합니다. 
만약 input : 4  4부터 도킹 시도! 

<br>
<br>
2. 2가지 경우로 나눈다. 

<br>
1. 해당 게이트 갑이 자기 자신일 경우
<br>
 게이트에 아무 비행기도 도킹되지 않았다는 뜻이므로 바로 넣고 이전 게이트 주소를 값으로 넣습니다. 
<br>
<img width="515" alt="image" src="https://github.com/gihwanJang/ProblemSolversHub/assets/91319157/257821f0-499d-48d7-963a-c79ed19fa0bd">

<br>
2. 넣으려고 하는 게이트의 값이 다른 값일 경우
<br>

현재 게이트는 다른 비행기가 도킹되어있다는 뜻이고 

Union_find 알고리즘 사용으로 부모노드(도킹 가능한 게이트 즉, 게이트주소와 값이 같은 곳 gate[i] == i)를 찾습니다. 
<br>
게이트 원소 값은 그곳에 도킹이 가능하다는 뜻이 되므로 그곳으로 이동하여 비행기를 도킹합니다. 


<hr>
<br><br>
<예외 사항>

- 이를 반복하면서 index를 벗어나면 도킹할 게이트가 없다는 뜻이므로
break를 통해 중단합니다. 




