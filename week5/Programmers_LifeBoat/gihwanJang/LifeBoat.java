import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        for(int lo = 0, hi = people.length-1; lo <= hi; ++res, --hi){
            if(people[hi] + people[lo] <= limit) { ++lo; }
        }
        return res;
    }
}

public class LifeBoat {
    public static void main(String[] args) {
        Solution problem = new Solution();
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(problem.solution(people, limit));
    }
}
