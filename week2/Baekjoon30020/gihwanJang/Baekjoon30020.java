import java.io.*;
import java.util.*;

public class Baekjoon30020 {
    public String solve(int a, int b) {
        if(a <= b || 2*b < a) return "NO";

        StringBuilder ans = new StringBuilder("YES\n");

        ans.append((a -= b + 1) + 1 + "\n");
        for(int i = 0; i < a; ++i)
            ans.append("aba\n");
        
        ans.append("a");
        for(int i = 0; i < b-a; ++i)
            ans.append("ba");

        return ans.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30020 problem = new Baekjoon30020();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(problem.solve(a, b));
    }
}
