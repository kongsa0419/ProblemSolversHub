import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    static char[][] map;
    static boolean[][] visited;

    static class Node {
        int x;
        int y;
        int manhattan;

        public Node(int x, int y, int manhattan) {
            this.x = x;
            this.y = y;
            this.manhattan = manhattan;
        }
    }

    public int[] solution(String[][] places) {
        map = new char[5][5];
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            int size = places[i].length;
            List<Node> personList = findTable(places[i]);
            int count = 0;
            for (Node person : personList) {
                visited = new boolean[5][5];
                if (dfs(new Node(person.x, person.y, 2), size)) {
                    count++;
                }
            }
            if (count == personList.size())
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }

    private boolean dfs(Node perNode, int size) {
        int[] nx = { 1, -1, 0, 0 };
        int[] ny = { 0, 0, 1, -1 };
        Stack<Node> stac = new Stack<>();
        stac.add(perNode);

        while (!stac.isEmpty()) {
            Node now = stac.pop();
            visited[now.x][now.y] = true;

            if (now.manhattan <= 0) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = now.x + nx[i];
                int nextC = now.y + ny[i];

                if (isValid(nextR, nextC)) {
                    if (map[nextR][nextC] == 'P' && now.manhattan >= 1) {
                        return false;
                    }
                    stac.add(new Node(nextR, nextC, now.manhattan - 1));
                }
            }
        }
        return true;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < 5 && c < 5 && visited[r][c] != true && map[r][c] != 'X';
    }

    private List<Node> findTable(String[] place) {
        List<Node> personList = new ArrayList<>();

        for (int r = 0; r < place.length; r++) {
            for (int c = 0; c < place[r].length(); c++) {
                map[r][c] = place[r].charAt(c);
                if (place[r].charAt(c) == 'P') {
                    personList.add(new Node(r, c, 3));
                }
            }
        }
        return personList;
    }
}

class CheckDistance {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] strings = {
                { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
                { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" }
        };

        String[][] strings1 = {
                { "POOOO", "XPOOO", "OOOOO", "OOOOO", "OOOOO" },
                { "OOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOO" },
                { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" }
        };
        System.out.println(Arrays.toString(solution.solution(strings1)));
    }
}