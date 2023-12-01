import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] solution(String[] gems) {
        int[] answer = twoPoint(gems);
        return answer;
    }

    public int[] twoPoint(String[] gems) {
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE;
        Set<String> diffType = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            diffType.add(gems[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        int start = 0;

        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (diffType.size() <= map.size() && length > end - start) {
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        return answer;
    }
}

public class JewelryShopping {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] gems = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
        System.out.println(Arrays.toString(solution.solution(gems.clone())));
    }
}