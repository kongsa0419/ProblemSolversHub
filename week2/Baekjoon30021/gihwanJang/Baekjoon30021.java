import java.io.*;

public class Baekjoon30021 {
    public String solve(int n) {
        StringBuilder sb = new StringBuilder("YES\n1");
        if(n == 1) return sb.toString();
        if(n == 2) return "NO";
        if(n > 2) sb.append(" 3 2").toString();
        if(n > 3) for(int i = 4; i <= n; ++i) sb.append(" " + i);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30021 problem = new Baekjoon30021();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(problem.solve(n));
    }
}
