import java.io.*;

class Problem {
    String bits;

    public Problem(String bits) {
        this.bits = bits;
    }

    public int solve() {
        int count = 0;
        boolean curr = false;

        for(int i = 0; i < bits.length(); ++i) {
            if(isOne(bits.charAt(i)) != curr) {
                curr = !curr;
                ++count;
            }
        }

        return count;
    }

    private boolean isOne(char c) {
        return c == '1';
    }
}

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            problem = new Problem(br.readLine());
            sb.append("#").append(t+1).append(" ").append(problem.solve()).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
