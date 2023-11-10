import java.io.*;
import java.util.*;

public class Baekjoon29293 {
    public static int solve(int a, int b) {
        double res = Math.log10(a) * b;
        return (int) res + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
}

