import java.io.*;

class Problem {
    int ret;
    int size;
    boolean[][] map;
    int[] dx = {-1, -1, -1};
    int[] dy = {0, -1, 1,};

    public Problem(int size) {
        this.size = size;
        map = new boolean[size][size];
        ret = 0;
    }

    public int solve() {
        backTraking(0, 0);
        return ret;
    }

    private void backTraking(int depth, int x) {
        if (depth == size) {
            ++ret;
            return;
        }

        for (int r = x; r < size; ++r)
            for (int c = 0; c < size; ++c)
                if (isValidate(r, c)) {
                    map[r][c] = true;
                    backTraking(depth+1, r+1);
                    map[r][c] = false;
                }
    }

    private boolean isValidate(int x, int y) {
        int r, c;
        for(int s = 0; s < size; ++s) {
            for(int i = 0; i < 3; ++i) {
                r = x + dx[i] * s;
                c = y + dy[i] * s;
                if(inRange(r, c) && map[r][c])
                    return false;
            }
        }
        return true;
    }

    private boolean inRange(int r, int c) {
        return (0 <= r && r < size
                &&
                0 <= c && c < size);
    }
}

public class SWEA2806 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            problem = new Problem(Integer.parseInt(br.readLine()));
            sb.append("#").append(t + 1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
