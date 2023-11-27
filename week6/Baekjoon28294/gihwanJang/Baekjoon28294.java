import java.io.*;
import java.util.*;

public class Baekjoon28294 {
    long MOD = 1000000007;
    long n, a;

    public long solve() {
        long k = (fastPow(n, a) - fastPow(n, a - 1) + MOD) % MOD;
        long ans = k + fastPow(n - 1, a);
        long u = (1 - fastPow(n, MOD - 2) + MOD) % MOD;
        ans += k * (u * (fastPow(u, a - 1) - 1 + MOD) % MOD) % MOD * fastPow(u - 1, MOD - 2) % MOD;
        return n % MOD * ans % MOD;
    }

    private long fastPow(long base, long exponent) {
        long ret = 1;
        for (int e = (int) exponent; e > 0; e /= 2) {
            if (e % 2 != 0) {
                ret *= base;
                ret %= MOD;
            }
            base *= base;
            base %= MOD;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        Baekjoon28294 problem = new Baekjoon28294();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        problem.n = Long.parseLong(st.nextToken());
        problem.a = Long.parseLong(st.nextToken());

        System.out.println(problem.solve());
    }
}
