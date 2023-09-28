import java.io.*;
import java.util.*;

public class Baekjoon30017 {
    int solve(int a, int b) {
        if(a <= b) return (2*a-1);
        return (2*b+1);
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30017 problem = new Baekjoon30017();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(problem.solve(a, b));
    }
}
