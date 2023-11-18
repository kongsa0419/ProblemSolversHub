import java.io.*;
import java.util.*;

class Dice {
    int x, y;
    int[] nums;
    
    public Dice(int x, int y) {
        this.x = x;
        this.y = y;
        nums = new int[6];
    }

    public int roll(int direct, int r, int c) {
        if(direct == 1) {
            move(4, 5, r, c);
        } else if(direct == 2) {
            move(5, 4, r, c);
        } else if(direct == 3) {
            move(1, 3, r, c);
        } else {
            move(3, 1, r, c);
        }
        return nums[0];
    }

    private void move(int b, int t, int r, int c) {
        int temp = nums[2];
        nums[2] = nums[b];
        nums[b] = nums[0];
        nums[0] = nums[t];
        nums[t] = temp;

        x += r;
        y += c;
    }

    @Override
    public String toString() {
        return "위 : " + nums[0] + "북 : " + nums[1] + "아래 : " + nums[2] + "남 : " + nums[3] + "동 : " + nums[4] +  "서 : " + nums[5];
    }
}

class Problem {
    int rowSize, colSize;
    int[][] map;
    Dice dice;
    int[] dx = {0, 0, 0, -1, 1};
    int[] dy = {0, 1, -1, 0, 0};

    public Problem(int rowSize, int colSize, int r, int c) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        dice = new Dice(r, c);
        map = new int[rowSize][colSize];
    }

    public int solve(int direct) {
        int top = dice.roll(direct, dx[direct], dy[direct]);

        if(map[dice.x][dice.y] == 0) {
            map[dice.x][dice.y] = dice.nums[2];
        } else {
            dice.nums[2] = map[dice.x][dice.y];
            map[dice.x][dice.y] = 0;
        }
        System.out.println(dice);
        return top;
    }

    public boolean isValidate(int direct) {
        return (
                0 <= dice.x + dx[direct] && dice.x + dx[direct] < rowSize
                &&
                0 <= dice.y + dy[direct] && dice.y + dy[direct] < colSize
        );
    }
}

public class Baekjoon14499 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int rSize = Integer.parseInt(st.nextToken());
        int cSize = Integer.parseInt(st.nextToken());
        int rLoc = Integer.parseInt(st.nextToken());
        int cLoc = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Problem problem = new Problem(rSize, cSize, rLoc, cLoc);

        for(int r = 0; r < rSize; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < cSize; ++c) {
                problem.map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; ++i) {
            int direct = Integer.parseInt(st.nextToken());
            if(problem.isValidate(direct)) {
                sb.append(problem.solve(direct)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
