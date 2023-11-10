import java.io.*;
import java.util.*;

class Location {
    int r, c, e;

    public Location(int r, int c, int e) {
        this.r = r;
        this.c = c;
        this.e = e;
    }
}

public class Baekjoon28291 {
    int h, w;
    int[][] map;
    int lamp_cnt = 0;
    int[] d_r = { -1, 1, 0, 0 };
    int[] d_c = { 0, 0, -1, 1 };
    Map<String, Integer> blockMap;

    public Baekjoon28291() {
        blockMap = new HashMap<>(3);
        blockMap.put("redstone_block", 1);
        blockMap.put("redstone_dust", 2);
        blockMap.put("redstone_lamp", 3);
    }

    public String solve() {
        List<Location> redstones = new ArrayList<>(10);

        for (int r = 0; r < h; ++r)
            for (int c = 0; c < w; ++c)
                if (map[r][c] == 1)
                    redstones.add(new Location(r, c, 15));

        BFS(redstones);

        return lamp_cnt == 0 ? "success" : "failed";
    }

    private void BFS(List<Location> redstones) {
        Location curr;
        boolean[][] visited = new boolean[h][w];
        Queue<Location> que = new ArrayDeque<>();

        for (Location loc : redstones)
            que.add(loc);

        while (!que.isEmpty()) {
            curr = que.poll();

            if (!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;
                if (isLamp(curr)) continue;
                step(curr, que, visited);   
            }
        }
    }

    private void step(Location curr, Queue<Location> que, boolean[][] visited) {
        int nextR, nextC;
        for (int i = 0; i < 4; ++i) {
            nextR = curr.r + d_r[i];
            nextC = curr.c + d_c[i];

            if (canGo(nextR, nextC, visited)) {
                if(map[curr.r][curr.c] == 1) {
                    que.add(new Location(nextR, nextC, curr.e));
                } else if(curr.e > 1) {
                    que.add(new Location(nextR, nextC, curr.e - 1));
                }
            }
        }
    }

    private boolean canGo(int r, int c, boolean[][] visited) {
        return isValidate(r, c) && !visited[r][c] && map[r][c] != 0;
    }

    private boolean isLamp(Location curr) {
        if (map[curr.r][curr.c] == 3) {
            --lamp_cnt;
            return true;
        }
        return false;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < h &&
                0 <= c && c < w);
    }

    public static void main(String[] args) throws IOException {
        Baekjoon28291 problem = new Baekjoon28291();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        problem.h = Integer.parseInt(st.nextToken());
        problem.w = Integer.parseInt(st.nextToken());
        problem.map = new int[problem.h][problem.w];

        for (int i = Integer.parseInt(br.readLine()), s, r, c; i > 0; --i) {
            st = new StringTokenizer(br.readLine());
            s = problem.blockMap.get(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            problem.map[r][c] = s;
            if (s == 3) ++problem.lamp_cnt;
        }

        System.out.println(problem.solve());
    }
}
