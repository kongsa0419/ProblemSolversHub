import java.io.*;
import java.util.*;

class Problem {
    int size;
    int[] buildings;

    public Problem(int size) {
        this.size = size;
        buildings = new int[size];
    }

    public int solve() {
        int res = 0;
        for (int i = 2, view; i < size - 2; ++i) {
            view = buildings[i] - getMaximumSide(i);
            if(view > 0) {res += view;}
        }
        return res;
    }

    private int getMaximumSide(int idx) {
        int side = 0;
        for (int s = 1; s < 3; ++s) {
            side = Math.max(side, buildings[idx - s]);
            side = Math.max(side, buildings[idx + s]);
        }
        return side;
    }
}

public class SWEA1206 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; ++i) {
            problem = new Problem(Integer.parseInt(br.readLine()));
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < problem.size; ++j) {
                problem.buildings[j] = Integer.parseInt(st.nextToken());
            }
            sb.append("#").append(i+1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.println(sb.toString());
    }
}