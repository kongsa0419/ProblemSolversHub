import java.io.*;
import java.util.*;

class Problem {
    int size;
    int[] scores;
    boolean[] visited;
    
    public Problem(int size) {
        this.size = size;
        scores = new int[size];
        visited = new boolean[10001];
    }

    public int solve() {
        List<Integer> nums = new ArrayList<>();

        nums.add(0);
        visited[0] = true;

        for(int i = 0; i < size; ++i) {
            int stop = nums.size();
            
            for(int j = 0; j < stop; ++j) {
                int newScore = nums.get(j) + scores[i];

                if(!visited[newScore]) {
                    nums.add(newScore);
                    visited[newScore] = true;
                }
            }
        }

        return nums.size();
    }

}

public class SWEA3752 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            problem = new Problem(Integer.parseInt(br.readLine()));
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < problem.size; ++i) {
                problem.scores[i] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(t+1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
