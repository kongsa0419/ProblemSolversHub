package seheeLee;
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for(int lowIndex = 0,highIndex = people.length-1; lowIndex <= highIndex  ;highIndex--,
            answer++){
            if(people[lowIndex] + people[highIndex] <= limit)lowIndex++;
        }
        return answer;
    }
}


public class Life_boat {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[5];
        a[0] =30;
        a[1] =40;
        a[2] =60;
        a[3] =70;
        a[4] =80;
        System.out.println(s.solution(a.clone(), 100));
    }
}


