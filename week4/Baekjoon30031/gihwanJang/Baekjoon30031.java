import java.io.*;
import java.util.*;

public class Baekjoon30031 {
    public int solve(int[] widths, int n) {
        int cost = 0;
        Map<Integer,Integer> moneyMap = new HashMap<>(4);

        moneyMap.put(136, 1000);
        moneyMap.put(142, 5000);
        moneyMap.put(148, 10000);
        moneyMap.put(154, 50000);

        for(int i = 0; i < n; ++i)
            cost += moneyMap.get(widths[i]);

        return cost;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30031 problem = new Baekjoon30031();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] widths = new int[n];

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            widths[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(problem.solve(widths, n));
    }    
}
