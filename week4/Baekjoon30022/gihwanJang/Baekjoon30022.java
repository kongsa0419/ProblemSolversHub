import java.util.*;
import java.io.*;

class Price implements Comparable<Price> {
    int p, q;

    @Override
    public int compareTo(Price o) {
        return Math.abs(o.p - o.q) - Math.abs(p - q);
    }
}

public class Baekjoon30022 {
    public long solve(int n, int a, int b, Price[] prices) {
        long totalPrice = 0;
        
        Arrays.sort(prices);
        for(int i = 0; i < n; ++i) {
            if(prices[i].p < prices[i].q) {
                if(a > 0) {
                    --a;
                    totalPrice += prices[i].p;
                }
                else {
                    --b;
                    totalPrice += prices[i].q;
                }
            }
            else {
                if(b > 0) {
                    --b;
                    totalPrice += prices[i].q;
                }
                else {
                    --a;
                    totalPrice += prices[i].p;
                }
            }
        }

        return totalPrice;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30022 problem = new Baekjoon30022();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Price[] prices = new Price[n];

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            prices[i] = new Price();
            prices[i].p = Integer.parseInt(st.nextToken());
            prices[i].q = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve(n, a, b, prices));
    }
}
