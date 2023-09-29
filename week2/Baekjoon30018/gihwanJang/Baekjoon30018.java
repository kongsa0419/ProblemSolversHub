import java.util.*;
import java.io.*;

public class Baekjoon30018 {
    public int solve(int[] before, int[] after, int n) {
        int cnt = 0;

        for(int i = 0; i < n; ++i)
            if(before[i] < after[i])
                cnt += after[i] - before[i];

        return cnt;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30018 problem = new Baekjoon30018();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] before = new int[n];
        int[] after = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
            before[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
            after[i] = Integer.parseInt(st.nextToken());

        System.out.println(problem.solve(before, after, n));
    }
}