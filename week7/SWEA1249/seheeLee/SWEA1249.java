
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class SWEA1249 {

    static int[][] visited;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dist = new int[n][n];
            visited = new int[n][n];

            for (int j = 0; j < n; j++) {
                String input = br.readLine();
                mapInit(input, n, j);
            }

            int result = dijkstra(n);
            System.out.println("#" + (i+1) + " "+ result);
        }
    }

    private static void mapInit(String lineMap, int n, int i) {
        String[] one = lineMap.split("");
        for (int j = 0; j < n; j++) {
            map[i][j] = Integer.parseInt(one[j]);
            dist[i][j] = Integer.MAX_VALUE;
        }
    }

    private static int dijkstra(int n) {
        Queue<Node> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.recoveryTime, node2.recoveryTime));
        pq.offer(new Node(0, 0, map[0][0]));  // 출발지 초기화
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.x][current.y] == 1) {
                continue;
            }

            visited[current.x][current.y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isValid(nx, ny, n)) {
                    //current.recoveryTime  => 이전 노드 값
                    int cost = current.recoveryTime  + map[nx][ny]; //정점 값
                    
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }

    private static boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static class Node {
        int x;
        int y;
        int recoveryTime;

        public Node(int x, int y, int recoveryTime) {
            this.x = x;
            this.y = y;
            this.recoveryTime = recoveryTime;
        }
    }
}
