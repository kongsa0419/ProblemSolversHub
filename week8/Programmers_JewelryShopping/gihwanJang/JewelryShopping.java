import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int start = 0;
        int length = Integer.MAX_VALUE;
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>(kind);

        for(int end = 0; end < gems.length; ++end) {
            map.put(gems[end], map.getOrDefault(gems[end], 0)+1);

            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start])-1);
                ++start;
            }

            if(map.size() == kind && length > end - start) {
                length = end - start;
                answer[0] = start;
                answer[1] = end;
            }
        }

        return answer;
    }
}

public class JewelryShopping {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        for(int i : solution.solution(gems))
            System.out.print(i + " ");
    }
}
