import java.io.*;
import java.util.*;

class Triangle{
    int side;
    double area;

    public Triangle(int[] sides, int a, int b, int c) {
        this.side = (1 << a | 1 << b | 1 << c);
        this.area = getArea(sides, a, b, c);
    }

    private double getArea(int[] sides, int a, int b, int c) {
        double p = (double)(sides[a] + sides[b] + sides[c]) / 2;
        return Math.sqrt(p * (p-sides[a]) * (p-sides[b]) * (p-sides[c]));
    }
}

public class Baekjoon1139 {
    public double solve(int[] fences, int n) {
        double max_area = 0;
        double[] DP = new double[1 << (n + 1)];
        List<Triangle> triangles = new LinkedList<>();

        Arrays.sort(fences, 0, n);

        for(int a = 0; a < n; ++a)
            for(int b = a+1; b < n; ++b)
                for(int c = b+1; c < n; ++c)
                    if(fences[a] + fences[b] > fences[c])
                        triangles.add(new Triangle(fences, a, b, c));

        for(Triangle t : triangles)
            DP[t.side] = t.area;
        
        for(int i = 0; i < DP.length; ++i)
            if(DP[i] != 0)
                for(Triangle t : triangles)
                    if((i & t.side) == 0)
                        DP[i | t.side] = Math.max(DP[i | t.side], DP[i] + t.area);

        for(int i = 0; i < DP.length; ++i)
            max_area = Math.max(max_area, DP[i]);

        return max_area;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon1139 problem = new Baekjoon1139();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fences = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; ++i)
            fences[i] = Integer.parseInt(st.nextToken());

        System.out.println(problem.solve(fences, n));
    }
}