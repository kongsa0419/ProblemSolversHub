import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class SWEA2819 {

    static int[][] map;
    static Set<String> paths;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            map = new int[4][4];
            paths = new HashSet<>();
            result = 0;

            for (int j = 0; j < 4; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < 4; k++) {
                    map[j][k] = Integer.parseInt(input[k]);
                }
            }

            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    dfs(r, c, 1, String.valueOf(map[r][c]));
                }
            }
            // for (String path : paths) {
                // System.out.println(path);
            // }

            System.out.println( "#" + i +  " " + paths.size());
        }
    }

    private static void dfs(int r, int c, int count, String current) {
        if (count == 7) {
            paths.add(current);
            return;
        }

        int[] nx = {0, 0, 1, -1};
        int[] ny = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nextR = nx[i] + r;
            int nextC = ny[i] + c;
            if (isValid(nextR, nextC)) {
                dfs(nextR, nextC, count + 1, current + map[nextR][nextC]);
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }
}
