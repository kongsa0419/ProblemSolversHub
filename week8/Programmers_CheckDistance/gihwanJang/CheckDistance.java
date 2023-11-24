import java.util.*;

class Location {
    int r, c, d;
    public Location(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    int size = 5;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int[] solution(String[][] places) {
        int[] answer = new int[size];

        for(int i = 0; i < size; ++i) {
            answer[i] = isValidate(places[i]);
        }

        return answer;
    }

    private int isValidate(String[] place) {
        for(int r = 0; r < size; ++r) {
            for(int c = 0; c < size; ++c) {
                if(place[r].charAt(c) == 'P')
                    if(!BFS(new Location(r, c, 0), place))
                        return 0;
            }
        }
        return 1;
    }
    private boolean BFS(Location loc, String[] place) {
        Location curr = loc;
        boolean[][] visited = new boolean[5][5];
        Queue<Location> que = new ArrayDeque<>(5);
        que.add(curr);

        while(!que.isEmpty()) {
            curr = que.poll();

            if(!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;

                if(curr.d != 0 && curr.d < 3 && place[curr.r].charAt(curr.c) == 'P')
                    return false;

                for(int i = 0; i < 4; ++i) {
                    int nextR = curr.r + dx[i];
                    int nextC = curr.c + dy[i];
                    if(isValidate(nextR, nextC) && place[nextR].charAt(nextC) != 'X')
                        que.add(new Location(nextR, nextC, curr.d + 1));
                }
            }
        }
        return true;
    }
    private boolean isValidate(int r, int c) {
        return (
            0 <= r && r < size
            &&
            0 <= c && c < size
        );
    }
}

public class CheckDistance {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        for(int v : solution.solution(places)) {
            System.out.print(v + " ");
        }
    }
}
