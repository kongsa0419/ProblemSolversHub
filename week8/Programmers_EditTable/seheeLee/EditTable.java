import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 삭제되면 true
        boolean[] table = new boolean[n];
        int current = k;
        Stack<Integer> trashBuffer = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 명령어 개수만큼 반복
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].charAt(0) == 'C') {
                table[current] = true;
                trashBuffer.add(current);
                if (current != n - 1) {
                    current++;
                } else {
                    current--;
                }
            } else if (cmd[i].charAt(0) == 'D') {
                String[] cmdString = cmd[i].split(" ");
                for (int a = 0; a < Integer.parseInt(cmdString[1]); a++) {
                    if (table[current+1]) {
                        while (table[current+1]) {
                            current++;
                        }
                        current++;
                    } else {
                        current++;
                    }
                }
            } else if (cmd[i].charAt(0) == 'U') {
                String[] cmdString = cmd[i].split(" ");
                for (int a = 0; a < Integer.parseInt(cmdString[1]); a++) {
                    if (table[current-1]) {
                        while (table[current-1]) {
                            current--;
                        }
                        current--;
                    } else {
                        current--;
                    }
                }
            } else if (cmd[i].charAt(0) == 'Z') {
                table[trashBuffer.pop()] = false;
            }
        }

        //답 출력
        for (int i = 0; i < n; i++) {
            if (table[i] == false)
                sb.append("O");
            else
                sb.append("X");
        }
        String answer = sb.toString();
        return answer;
    }
}

class EditTable {
    public static void main(String[] args) {
        String[] commands = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
        String[] commands1 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 2, commands1));
    }
}