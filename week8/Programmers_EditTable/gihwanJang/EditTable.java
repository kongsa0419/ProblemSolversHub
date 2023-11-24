import java.util.*;

class Solution {
    int iter;
    boolean[] table;
    Stack<Integer> removed;
    TreeSet<Integer> tableSet;

    public String solution(int n, int k, String[] cmd) {
        init(n, k);
        for (String commend : cmd) {
            if (commend.charAt(0) == 'D') {
                moveDown(getLoc(commend));
            } else if (commend.charAt(0) == 'U') {
                moveUp(getLoc(commend));
            } else if (commend.charAt(0) == 'C') {
                delete();
            } else {
                recovery();
            }
            //System.out.println(getResult() + " curr : " + iter);
        }
        return getResult();
    }

    private void init(int n, int k) {
        iter = k;
        table = new boolean[n];
        removed = new Stack<>();
        tableSet = new TreeSet<>();
        Arrays.fill(table, true);
        for(int i = 0; i < n; ++i)
            tableSet.add(i);
    }

    private void moveDown(int cnt) {
        for(int i = 0; i < cnt; ++i) {
            iter = tableSet.higher(iter);
        }
    }

    private void moveUp(int cnt) {
        for(int i = 0; i < cnt; ++i) {
            iter = tableSet.lower(iter);
        }
    }

    private int getLoc(String commend) {
        String[] commends = commend.split(" ");
        return Integer.parseInt(commends[1]);
    }

    private void delete() {
        removed.add(iter);
        table[iter] = false;
        tableSet.remove(iter);
        moveIter();
    }

    private void moveIter() {
        if(tableSet.higher(iter) != null) {
            iter = tableSet.higher(iter);
        } else {
            iter = tableSet.lower(iter);
        }
    }

    private void recovery() {
        int prevRomved = removed.pop();
        table[prevRomved] = true;
        tableSet.add(prevRomved);
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; ++i) {
            sb.append((table[i] ? 'O' : 'X'));
        }
        return sb.toString();
    }
}

public class EditTable {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cmd = { "D 2","C","U 3","C","D 4","C","U 2","Z","Z" };
        System.out.println(solution.solution(8, 2, cmd));
    }
}
