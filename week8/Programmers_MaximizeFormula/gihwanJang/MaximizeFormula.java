import java.util.*;

class Solution {
    List<String> formulaList;
    String[][] scedules = {
            {"+","-","*"}, {"+","*","-"},
            {"*","+","-"}, {"*","-","+"},
            {"-","+","*"}, {"-","*","+"}};

    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        splitFormula(expression);
        for(int i  = 0; i < 6; ++i)
            answer = Math.max(answer, Math.abs(calculate(scedules[i])));
        return answer;
    }

    private void splitFormula(String expression) {
        StringBuilder sb = new StringBuilder();
        formulaList = new ArrayList<>();

        for(int i = 0; i < expression.length(); ++i) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                formulaList.add(sb.toString());
                formulaList.add(String.valueOf(expression.charAt(i)));
                sb = new StringBuilder();
            } else {
                sb.append(expression.charAt(i));
            }
        }

        if(sb.length() != 0) formulaList.add(sb.toString());
    }
    private long calculate(String[] scedule) {
        Stack<String> stack = new Stack<>();
        Deque<String> formulaCopy = new ArrayDeque<>(formulaList);

        for(int i = 0; i < 3; ++i) {
            stack.clear();
            while(!formulaCopy.isEmpty()) {
                stack.push(formulaCopy.pollFirst());

                if(stack.peek().equals(scedule[i])) {
                    stack.pop();
                    if(scedule[i].equals("+")) {
                        stack.push(add(stack.pop(), formulaCopy.pollFirst()));
                    }
                    else if(scedule[i].equals("-")) {
                        stack.push(sub(stack.pop(), formulaCopy.pollFirst()));
                    }
                    else {
                        stack.push(mul(stack.pop(), formulaCopy.pollFirst()));
                    } 
                }
            }
            formulaCopy = new ArrayDeque<>(stack);
            System.out.println(stack);
        }

        return Long.parseLong(stack.pop());
    }
    private String add(String a, String b) {
        return String.valueOf(Long.parseLong(a) + Long.parseLong(b));
    }
    private String sub(String a, String b) {
        return String.valueOf(Long.parseLong(a) - Long.parseLong(b));
    }
    private String mul(String a, String b) {
        return String.valueOf(Long.parseLong(a) * Long.parseLong(b));
    }
}

public class MaximizeFormula {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100-200*300-500+20"));
        System.out.println(solution.formulaList);
    }   
}
