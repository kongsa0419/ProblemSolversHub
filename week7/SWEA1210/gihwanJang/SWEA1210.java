import java.io.*;
import java.util.*;

class Location {
    int x, y;
    public Location() {}
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Problem {
    int size = 100;
    int[][] map;

    public Problem() { map = new int[size][size]; }

    public int solve() {
        Location curr = getStarLocation();

        while(curr.x != 0) {
            if(isValidate(curr.x, curr.y-1) && map[curr.x][curr.y-1] == 1) {
                while(map[curr.x-1][--curr.y] != 1) {}
            } else if(isValidate(curr.x, curr.y+1) && map[curr.x][curr.y+1] == 1) {
                while(map[curr.x-1][++curr.y] != 1) {}
            }
            --curr.x;
        }

        return curr.y;
    }

    private Location getStarLocation() {
        for(int c = 0; c < size; ++c)
            if(map[size-1][c] == 2)
                return new Location(size-1, c);
        return new Location(0, -1);
    }

    private boolean isValidate(int x, int y) {
        return (0 <= x && x < size
                &&
                0 <= y && y < size);
    }
}

public class SWEA1210 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0, j; i < 10; ++i) {
            problem = new Problem();
            j = Integer.parseInt(br.readLine());
            for(int r = 0; r < problem.size; ++r) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < problem.size; ++c) {
                    problem.map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(j).append(" ").append(problem.solve()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
