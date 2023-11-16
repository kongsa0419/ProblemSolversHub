import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA2806 {

    static int N;
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tc; i++) {
            N = Integer.parseInt(br.readLine());
            solveNQueens();
            int count ;
            if (result.isEmpty()) {
               count = 0;
               System.out.println("#" + i + " " + count);
            } else {
                count = result.size();
                System.out.println("#" + i + " " + count);
            }
            result.clear();
        }
    }

    private static void solveNQueens() {
        List<Integer> placement = new ArrayList<>();
        placeQueens(0, placement);
    }

    private static void placeQueens(int row, List<Integer> placement) {
        if (row == N) {
            result.add(new ArrayList<>(placement));
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValidPlacement(row, col, placement)) {
                placement.add(col); //
                placeQueens(row + 1, placement); //다음 행 해보기
                placement.remove(placement.size() - 1);
            }
        }
    }

    private static boolean isValidPlacement(int row, int col, List<Integer> placement) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = placement.get(prevRow);
            if (prevCol == col || prevRow + prevCol == row + col || prevRow - prevCol == row - col) {
                return false;
            }
        }
        return true;
    }
}
