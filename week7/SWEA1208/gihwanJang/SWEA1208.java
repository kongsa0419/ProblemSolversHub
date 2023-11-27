import java.io.*;
import java.util.*;

class Problem {
    int dump;
    int[] hights;

    public Problem(int n) {
        dump = n;
        hights = new int[100];
    }

    public int solve() {
        int lo = 0, hi = 0;

        for(int i = 0; i < dump; ++i, --hights[hi], ++hights[lo]) {
            for(int j = 0; j < 100; ++j) {
                if (hights[lo] > hights[j]) lo = j;
                if (hights[hi] < hights[j]) hi = j;
            }
        }

        for(int j = 0; j < 100; ++j) {
            if (hights[lo] > hights[j]) lo = j;
            if (hights[hi] < hights[j]) hi = j;
        }

        return hights[hi] - hights[lo];
    }
}

public class SWEA1208 {

    public static void main(String[] args) throws IOException {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; ++t) {
            problem = new Problem(Integer.parseInt(br.readLine()));
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; ++i) {
                problem.hights[i] = Integer.parseInt(st.nextToken());
            }
            sb.append('#').append(t+1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
