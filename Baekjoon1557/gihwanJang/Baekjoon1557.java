import java.io.*;
import java.util.*;

class NumberInfo {
    int cnt;
    int idx;
    long num;

    NumberInfo(int cnt, int idx, long num) {
        this.cnt = cnt;
        this.idx = idx;
        this.num = num;
    }
}

public class Baekjoon1557 {
    private List<Long> eratosthenes(int k) {
        List<Long> prime = new LinkedList<>();
        boolean isPrime[] = new boolean[k];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i < k; ++i) {
            if(!isPrime[i]) continue;

            for(int j = i * i; j < k; j += i)
                isPrime[j] = false;
        }

        for(int i = 2; i < k; ++i)
            if(isPrime[i])
                prime.add((long)i);

        return prime;
    }

    private long getNum(List<Long> prime, long mid) {
        long p;
        long square = 0;
        NumberInfo curr;
        Queue<NumberInfo> que = new ArrayDeque<>();

        for (int i = 0; i < prime.size(); ++i) {
            p = prime.get(i);
            if (p * p > mid) break;
            que.add(new NumberInfo(1, i, p));
        }

        while(!que.isEmpty()) {
            curr = que.poll();

            square += ((curr.cnt & 1) == 1 ? 1 : -1) * (mid / (curr.num * curr.num));

            for (int i = curr.idx + 1; i < prime.size(); ++i) {
                p = prime.get(i);

                if (curr.num * p * curr.num * p > mid) break;
                if (curr.num % p == 0) continue;

                que.add(new NumberInfo(curr.cnt + 1, i, curr.num * p));
            }
        }

        return mid - square;
    }

    public long solve(int n) {
        long lo = 0;
        long hi = (long)2e9;
        List<Long> prime = eratosthenes((int)(Math.sqrt(hi)+1));

        while (lo + 1 < hi) {
            long mid = (lo + hi) >> 1;
            if (getNum(prime, mid) < n) lo = mid;
            else hi = mid;
        }

        return hi;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon1557 problem = new Baekjoon1557();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(problem.solve(n));
    }
}
