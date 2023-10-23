import java.io.*;

public class Baekjoon30030 {
    public int solve(int b) {     
        return (b / 11 * 10);
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30030 problem = new Baekjoon30030();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        System.out.println(problem.solve(b));
    }
}
