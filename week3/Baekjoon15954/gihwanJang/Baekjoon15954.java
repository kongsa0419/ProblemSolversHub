import java.util.*;
import java.io.*;

public class Baekjoon15954 {
    public double getSTDEV(int[] researchs, int n, int s, int i) {
        double mean = 0;
        double DEV = 0;

        for(int j = 0; j < s; ++j)
            mean += researchs[i+j];
        mean /= s;

        for(int j = 0; j < s; ++j)
            DEV +=  Math.pow(mean - researchs[i+j],2);
        DEV /= s;

        return Math.sqrt(DEV);
    }

    public double solve(int[] researchs, int n, int k) {
        double minSTDEV = Double.MAX_VALUE;

        for(int s = k; s <= n; ++s)
            for(int i = 0; i + s <= n; ++i)
                minSTDEV = Math.min(minSTDEV, getSTDEV(researchs, n, s, i));

        return minSTDEV;
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon15954 problem = new Baekjoon15954();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] researchs = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
            researchs[i] = Integer.parseInt(st.nextToken());
        
        System.out.println(problem.solve(researchs, n, k));
    }    
}
