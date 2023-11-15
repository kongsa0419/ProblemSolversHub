import java.io.*;

class Problem {
    int size;
    int[][] map;

    public Problem(int size) {
        this.size = size;
        map = new int[size][size];
    }

    public int solve() {
        int sum = 0;
        int cutLine = size/2;
        for(int r = 0; r < size; ++r) {
            for(int c = 0; c < size; ++c) {
                int t_r = r > cutLine ? size - r - 1 : r;
                int t_c = c > cutLine ? size - c - 1 : c;
                
                if(t_r + t_c >= cutLine)
                    sum += map[r][c];
            }
        }
        return sum;
    }
}

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            problem = new Problem(Integer.parseInt(br.readLine()));
            
            for(int r = 0; r < problem.size; ++r) {
                String row = br.readLine();
                for(int c = 0; c < problem.size; ++c)
                    problem.map[r][c] = row.charAt(c) - '0';
            }

            sb.append("#").append(t+1).append(" ").append(problem.solve()).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
