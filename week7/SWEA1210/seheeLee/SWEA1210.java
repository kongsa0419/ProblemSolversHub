import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1210 {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }

    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int count=0 ; count < 10; count ++) {
            int tc = Integer.parseInt(br.readLine());
            int n = 100;
            map = new int[n][n];
            visited = new boolean[n][n];
            for(int r = 0; r < n ; r++) {
                String[] string = br.readLine().split(" ");
                for(int c = 0; c < n; c++) {
                    map[r][c] = Integer.parseInt(string[c]);
                }
            }
            for(int i = 0; i < n; i++ ){
                if(map[n-1][i] == 2 ){
                    System.out.println("#"+tc+" "+ dfs(new Node(n-1, i)));
                }
            }
        
        }
    }


    private static int dfs(Node start) {
        int[] dx = { 0, 0 , -1 }; //오 , 왼 ,위
        int[] dy = { 1, -1, 0 };
        Stack<Node> stac = new Stack<>();
        stac.add(start);
        Node endPoint = new Node(0, 0);

        while(!stac.isEmpty()){
            Node currentNode = stac.pop();
            visited[currentNode.x][currentNode.y] = true;

            for(int i = 0; i < 3; i++) {
                int nextR = currentNode.x + dx[i];
                int nextC = currentNode.y + dy[i];
                if(isValid(nextR, nextC)){
                    stac.add(new Node(nextR, nextC));
                    endPoint.x = nextR;
                    endPoint.y = nextC;
                    break;
                }
            }
        }
        return endPoint.y;
    }


    private static boolean isValid(int r, int c) {
        return r>=0 && r < map.length && c>=0 && c < map.length && map[r][c] == 1 && visited[r][c] != true;
    }
}
