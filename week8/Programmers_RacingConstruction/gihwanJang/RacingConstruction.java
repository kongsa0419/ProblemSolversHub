import java.util.*;

class Location implements Comparable<Location> {
    int r, c, dis, dir;

    public Location(int r, int c, int dis, int dir) {
        this.r = r;
        this.c = c;
        this.dis = dis;
        this.dir = dir;
    }

    @Override
    public int compareTo(Location o) {
        return dis - o.dis;
    }
}

class Solution {
    int size;
    int[][][] distance;

    public int solution(int[][] board) {
        size = board.length;
        distance = new int[size][size][4];
        initDistance();
        djikstra(board);
        return Math.min(distance[size - 1][size - 1][1], distance[size-1][size-1][3]);
    }

    private void initDistance() {
        for (int r = 0; r < size; ++r)
            for(int c = 0; c < size; ++c)
                Arrays.fill(distance[r][c], Integer.MAX_VALUE);
        for(int i = 0; i < 4; ++i)
            distance[0][0][i] = 0;
    }

    private void djikstra(int[][] board) {
        Location curr;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        PriorityQueue<Location> pq = new PriorityQueue<>();

        if (board[0][1] != 1) {
            pq.add(new Location(0, 1, 100, 3));
        }
        if (board[1][0] != 1) {
            pq.add(new Location(1, 0, 100, 1));
        }

        while (!pq.isEmpty()) {
            curr = pq.poll();

            if (curr.dis < distance[curr.r][curr.c][curr.dir]) {
                distance[curr.r][curr.c][curr.dir] = curr.dis;

                for (int i = 0; i < 4; ++i) {
                    int nextR = curr.r + dx[i];
                    int nextC = curr.c + dy[i];

                    if (isValidate(nextR, nextC) && board[nextR][nextC] != 1) {
                        pq.add(new Location(nextR, nextC, curr.dis + getCost(curr.dir, i), i));
                    }
                }
            }
        }
    }

    private int getCost(int curr, int next) {
        if ((curr < 2 && next < 2)
                ||
                (1 < curr && 1 < next)) {
            return 100;
        }
        return 600;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < size
                &&
                0 <= c && c < size);
    }
}

public class RacingConstruction {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 }
        };
        System.out.println(solution.solution(board));
    }
}
