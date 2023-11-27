# 풀이

해당 문제는 전수조사를 요하는 문제입니다.  
아래는 전수조사의 코드입니다.  

해당 코드를 이용하여 입력 범위인 1~100까지의 모든 값을 본 결과 1~2는 1을 3~5는 2를 그 이후는 3을 출력합니다.  
그러므로 위의 결과와 동일하게 출력해 주면 됩니다.


```java
import java.io.*;
import java.util.*;

class Pair {
    char num;
    int cnt;
    public Pair(char num) {
        this.num = num;
        this.cnt = 1;
    }
}

public class Main {
    private String getNextGemi(String gemi) {
        StringBuilder sb = new StringBuilder();
        List<Pair> gemiList = new ArrayList<>(2*gemi.length());

        gemiList.add(new Pair(gemi.charAt(0)));
        for(int i = 1; i < gemi.length(); ++i) {
            if(gemi.charAt(i) == gemi.charAt(i-1)) {
                ++gemiList.get(gemiList.size()-1).cnt;
            } else {
                gemiList.add(new Pair(gemi.charAt(i)));
            }
        }

        for(Pair p : gemiList)
            sb.append(p.num).append(p.cnt);
        return sb.toString();
    }

    private char getMaxNum(String s) {
        char n = '0';
        for(int i = 0; i < s.length(); ++i)
            if(n < s.charAt(i))
                n = s.charAt(i);
        return n;
    }

    public char solve(int n) {
        String gemi = "1";
        for(int i = 1; i < n; ++i)
            gemi = getNextGemi(gemi);
        return getMaxNum(gemi);
    }

    public static void main(String[] args) throws IOException {
        Main problem = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(problem.solve(Integer.parseInt(br.readLine())));
    }
}
```