import java.util.*;
import java.io.*;

public class Baekjoon30189 {
    int solve(int n, int m) {
        int cnt = 0;

        for(int i = 0; i <= n+m; ++i)
            for(int x = 0; x <= n; ++x)
                for(int y = 0; y <= m; ++y)
                    if(x + y == i) ++cnt;

        return cnt;
    }

    public static void main(String[] args) throws IOException, NullPointerException {
        Baekjoon30189 problem = new Baekjoon30189();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(problem.solve(n, m));
    }
}