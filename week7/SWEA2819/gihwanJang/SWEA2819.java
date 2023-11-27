import java.io.*;
import java.util.*;

class Problem {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int[][] map = new int[4][4];

    public int solve() {
        Set<Integer> set = new HashSet<>(1000);

        for(int r = 0; r < 4; ++r)
            for(int c = 0; c < 4; ++c)
                DFS(set, r, c, 0, 0);

        return set.size();
    }

    private void DFS(Set<Integer> set, int x, int y, int depth, int value) {
        if(depth == 7) {
            set.add(value);
            return;
        }

        for(int i = 0, r, c; i < 4; ++i) {
            r = x+dx[i];
            c = y+dy[i];

            if(isValidate(r, c))
                DFS(set, r, c, depth+1, value * 10 + map[r][c]);
        }
    }

    private boolean isValidate(int r, int c) {
        return (
            0 <= r && r < 4
            &&
            0 <= c && c < 4
        );
    }
}

public class SWEA2819 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            problem = new Problem();

            for(int r = 0; r < 4; ++r) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < 4; ++c) {
                    problem.map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t+1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
