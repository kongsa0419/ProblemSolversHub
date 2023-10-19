import java.io.*;
import java.util.*;

public class Baekjoon30032 {
    Map<Character,Character> upDownMap = new HashMap<>(4);
    Map<Character,Character> leftRightMap = new HashMap<>(4);

    public Baekjoon30032() {
        upDownMap.put('d', 'q');
        upDownMap.put('b', 'p');
        upDownMap.put('q', 'd');
        upDownMap.put('p', 'b');

        leftRightMap.put('d', 'b');
        leftRightMap.put('b', 'd');
        leftRightMap.put('q', 'p');
        leftRightMap.put('p', 'q');
    }

    public String solve(String s, int d) {
        StringBuilder sb = new StringBuilder(s);
        if(d == 1)
            for(int i = 0; i < s.length(); ++i)
                sb.setCharAt(i, upDownMap.get(sb.charAt(i)));
              
        if(d == 2)
            for(int i = 0; i < s.length(); ++i)
                sb.setCharAt(i, leftRightMap.get(sb.charAt(i)));

        return sb.append("\n").toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30032 problem = new Baekjoon30032();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; ++i)
            sb.append(problem.solve(br.readLine(), d));

        System.out.print(sb.toString());
    }
}
