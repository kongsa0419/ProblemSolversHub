import java.io.*;
import java.util.*;

class Location implements Comparable<Location> {
    int x,y,d;

    public Location(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    @Override
    public int compareTo(Location o) {
        return d - o.d;
    }

}

class Problem {
    int size;
    int[][] map;
    int[][] distance;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public Problem(int size) {
        this.size = size;
        map = new int[size][size];
        setDistance();
    }

    public int solve() {
        Location curr;
        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(0, 0, 0));

        while(!pq.isEmpty()) {
            curr = pq.poll();

            if(curr.d < distance[curr.x][curr.y]) {
                distance[curr.x][curr.y] = curr.d;

                for(int i = 0; i < 4; ++i) {
                    int nextX = curr.x + dx[i];
                    int nextY = curr.y + dy[i];
                    
                    if(isValidate(nextX, nextY)) {
                        pq.add(new Location(nextX, nextY, curr.d + map[nextX][nextY]));
                    }
                }
            }
        }

        return distance[size-1][size-1];
    }

    private boolean isValidate(int x, int y) {
        return (0 <= x && x < size
                &&
                0 <= y && y < size);
    }

    private void setDistance() {
        distance = new int[size][size];
        for (int r = 0; r < size; ++r) {
            Arrays.fill(distance[r], 987654321);
        }
    }
}

public class SWEA1249 {
    public static void main(String[] args) throws IOException {
        Problem problem;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            problem = new Problem(Integer.parseInt(br.readLine()));

            for (int r = 0; r < problem.size; ++r) {
                String rowLine = br.readLine();

                for (int c = 0; c < problem.size; ++c) {
                    problem.map[r][c] = rowLine.charAt(c) - '0';
                }
            }

            sb.append("#").append(t + 1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
