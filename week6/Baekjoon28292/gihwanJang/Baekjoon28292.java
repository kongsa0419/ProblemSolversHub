import java.io.*;

public class Baekjoon28292 {
    public int solve(int n) {
        if(n < 3) return 1;
        if(n < 6) return 2;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        Baekjoon28292 problem = new Baekjoon28292();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(problem.solve(Integer.parseInt(br.readLine())));
    }
}