import java.io.*;
import java.util.*;

class Pair {
    int num, cnt;

    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
    @Override
    public boolean equals(Object o) {
        Pair p = (Pair) o;
        return num == p.num && cnt == p.cnt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + num;
        hash = 31 * hash + cnt;
        return hash;
    }
}

class Problem {
    int num;
    int length;
    int swapCnt;

    public Problem(String num, int swapCnt) {
        this.length = num.length();
        this.swapCnt = swapCnt;
        this.num = Integer.parseInt(num);
    }

    public int solve() {
        int ret = 0;
        Queue<Pair> que = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>(1000);
        que.offer(new Pair(num, 0));

        while (!que.isEmpty()) {
            Pair curr = que.poll();

            if (!visited.contains(curr)) {
                visited.add(curr);

                if (curr.cnt == swapCnt) {
                    ret = Math.max(ret, curr.num);
                    continue;
                }

                for (int i = 0; i < length; ++i)
                    for (int j = i + 1; j < length; ++j)
                        que.offer(new Pair(swap(curr.num, i, j), curr.cnt + 1));
            }
        }

        return ret;
    }

    private int swap(int trans, int a, int b) {
        int temp;
        int ret = 0;
        int digit = (int) Math.pow(10, length - 1);
        int[] transArray = new int[length];
        for (int i = digit, j = 0; i > 0; i /= 10, ++j) {
            transArray[j] = trans / i;
            trans %= i;
        }
        temp = transArray[a];
        transArray[a] = transArray[b];
        transArray[b] = temp;
        for (int i = digit, j = 0; i > 0; i /= 10, ++j) {
            ret += i * transArray[j];
        }
        return ret;
    }
}

public class SWEA1244 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            st = new StringTokenizer(br.readLine());
            problem = new Problem(st.nextToken(), Integer.parseInt(st.nextToken()));
            sb.append("#").append(t + 1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}