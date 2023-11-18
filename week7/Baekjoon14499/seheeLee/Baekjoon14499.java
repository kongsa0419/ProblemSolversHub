import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon14499 {

    static int[][] map;
    static int[] diceX = new int[6];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSizeAndStartAndCommand = br.readLine().split(" ");

        n = Integer.parseInt(mapSizeAndStartAndCommand[0]);
        m = Integer.parseInt(mapSizeAndStartAndCommand[1]);

        int diceR = Integer.parseInt(mapSizeAndStartAndCommand[2]);
        int diceC = Integer.parseInt(mapSizeAndStartAndCommand[3]);

        map = new int[n][m];
        for (int r = 0; r < n; r++) {
            String[] mapStrings = br.readLine().split(" ");
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(mapStrings[c]);
            }
        }

        String[] commandStrings = br.readLine().split(" ");
        int[] command = Arrays.stream(commandStrings).mapToInt(Integer::parseInt).toArray();

        throwDice(command, diceR, diceC);
    }

    private static void throwDice(int[] command, int currentR, int currentC) {
        for (int i = 0; i < command.length; i++) {
            // 동쪽
            if (command[i] == 1 && isValidateMove(currentR, currentC + 1)) {
                if (map[currentR][currentC] == 0 && isValidateMove(currentR, currentC)) {
                    map[currentR][currentC] = diceX[1];
                } else if (isValidateMove(currentR, currentC)) {
                    diceX[1] = map[currentR][currentC];
                    map[currentR][currentC] = 0;
                }
                int north = diceX[0];
                int bottom = diceX[1];
                int south = diceX[2];
                int top = diceX[3];
                int east = diceX[4];
                int west = diceX[5];

                diceX[5] = top;
                diceX[1] = west;
                diceX[4] = bottom;
                diceX[3] = east;
                currentC++;
                System.out.println(diceX[3]);

            }
            // 서쪽
            if (command[i] == 2 && isValidateMove(currentR, currentC - 1)) {
                if (map[currentR][currentC] == 0 && isValidateMove(currentR, currentC)) {
                    map[currentR][currentC] = diceX[1];
                } else if (isValidateMove(currentR, currentC)) {
                    diceX[1] = map[currentR][currentC];
                    map[currentR][currentC] = 0;
                }
                int north = diceX[0];
                int bottom = diceX[1];
                int south = diceX[2];
                int top = diceX[3];
                int east = diceX[4];
                int west = diceX[5];

                diceX[1] = east;
                diceX[5] = bottom;
                diceX[3] = west;
                diceX[4] = top;
                currentC--;
                System.out.println(diceX[3]);

            }
            // 북
            if (command[i] == 3 && isValidateMove(currentR - 1, currentC)) {
                if (map[currentR][currentC] == 0 && isValidateMove(currentR, currentC)) {
                    map[currentR][currentC] = diceX[1];
                } else if (isValidateMove(currentR, currentC)) {
                    diceX[1] = map[currentR][currentC];
                    map[currentR][currentC] = 0;
                }
                int north = diceX[0];
                int bottom = diceX[1];
                int south = diceX[2];
                int top = diceX[3];
                int east = diceX[4];
                int west = diceX[5];

                diceX[1] = north;
                diceX[2] = bottom;
                diceX[3] = south;
                diceX[0] = top;

                currentR--;
                System.out.println(diceX[3]);

            }

            // 남
            if (command[i] == 4 && isValidateMove(currentR + 1, currentC)) {
                if (map[currentR][currentC] == 0 && isValidateMove(currentR, currentC)) {
                    map[currentR][currentC] = diceX[1];
                } else if (isValidateMove(currentR, currentC)) {
                    diceX[1] = map[currentR][currentC];
                    map[currentR][currentC] = 0;
                }
                int north = diceX[0];
                int bottom = diceX[1];
                int south = diceX[2];
                int top = diceX[3];
                int east = diceX[4];
                int west = diceX[5];
                diceX[2] = top;
                diceX[3] = north;
                diceX[1] = south;
                diceX[0] = bottom;
                currentR++;
                System.out.println(diceX[3]);
            }
        }
    }

    private static boolean isValidateMove(int nextR, int nextC) {
        return nextR >= 0 && nextR < n && nextC >= 0 && nextC < m;
    }
}
