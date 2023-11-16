import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA3752 {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            set.clear();
            int ans = 0;
            int N = Integer.parseInt(br.readLine());
            String[] inputStrings = br.readLine().split(" ");
            
            set.add(0);

            for (String input : inputStrings) {
                scoreSelect(Integer.parseInt(input));
            }

            ans = set.size();
            System.out.println("#" + test_case + " " + ans);
        }
        br.close();
    }

    static void scoreSelect(int num) {
        Set<Integer> newSet = new HashSet<>();
        for (int value : set) {
            newSet.add(value + num);
        }
        set.addAll(newSet);
    }
}
