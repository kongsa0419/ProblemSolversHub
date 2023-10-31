import java.io.*;
import java.util.*;

class Point {
    double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getDistance (Point p) {
        return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
    }
}

public class Baekjoon20631 {
    int k;
    Point[] points;
    
    private double getSum(Point p) {
        double sum = 0;
        double[] distance = new double[points.length];
        for(int i = 0; i < points.length; ++i) {
            distance[i] = p.getDistance(points[i]);
        }
        Arrays.sort(distance);
        for(int i = points.length - 1; i >= points.length - k; --i) {
            sum += distance[i];
        }
        return sum;
    }
    private double getY(double x) {
        double ll = -1000;
        double rr = 1000;
        while(rr - ll > 1e-5) {
            double l3 = (ll + ll + rr) / 3;
            double r3 = (ll + rr + rr) / 3;
            if(getSum(new Point(x, l3)) < getSum(new Point(x, r3))) { rr = r3; }
            else { ll = l3; }
        }
        return getSum(new Point(x, ll));
    }
    private double getX() {
        double ll = -1000;
        double rr = 1000;
        while(rr - ll > 1e-5) {
            double l3 = (ll + ll + rr) / 3;
            double r3 = (ll + rr + rr) / 3;
            if(getY(l3) < getY(r3)) { rr = r3; }
            else { ll = l3; }
        }
        return getY(ll);
    }
    public double solve () { return getX(); }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon20631 problem = new Baekjoon20631();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        problem.k = Integer.parseInt(st.nextToken());
        problem.points = new Point[n];
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.points[i] = new Point(
                Double.parseDouble(st.nextToken()), 
                Double.parseDouble(st.nextToken())
            );
        }
        System.out.println(problem.solve());
    }
}
