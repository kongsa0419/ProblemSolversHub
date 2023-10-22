### 풀이

미리 상하반전, 좌우반전을 계산한 값을 배열로 2차원 배열로 저장해서 
여러가지 if문을 통해서 해당 값을 얻어온다. 

```

if(inputStrings1[j]=='b' && reversal==1 )answer[j] = alpha[0][2];
                else if(inputStrings1[j]=='d' && reversal==1 )answer[j] = alpha[1][2];
                else if(inputStrings1[j]=='q' && reversal==1 )answer[j] = alpha[2][2];
                else if(inputStrings1[j]=='p' && reversal==1 )answer[j] = alpha[3][2];
                else if(inputStrings1[j]=='b' && reversal==2 )answer[j] = alpha[0][1];
                else if(inputStrings1[j]=='d' && reversal==2 )answer[j] = alpha[1][1];
                else if(inputStrings1[j]=='q' && reversal==2 )answer[j] = alpha[2][1];
                else if(inputStrings1[j]=='p' && reversal==2 )answer[j] = alpha[3][1];

```


하지만 배열을 사용하는 것보다 Map구조로 하는 것이 더 깔끔해보인다. 
