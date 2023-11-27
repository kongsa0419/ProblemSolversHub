import java.io.*;
import java.util.*;

class Gear {
    private int northIdx;
    private boolean[] state;

    public Gear(String s) {
        state = new boolean[8];
        setState(s);
        northIdx = 0;
    }
    public boolean getTop() {
        return state[northIdx];
    }
    public boolean getLeft() {
        return state[(northIdx + 6) % 8];
    }
    public boolean getRight() {
        return state[(northIdx + 2) % 8];
    }
    public void rotateLeft() {
        northIdx = (northIdx + 1) % 8;
    }
    public void rotateRight() {
        northIdx = (northIdx + 7) % 8;
    }

    private void setState(String s) {
        for(int i = 0; i < 8; ++i)
            state[i] = s.charAt(i) == '1';
    }
}


class Problem {
    private Gear[] gears;

    public Problem() {
        gears = new Gear[4];
    }
    public void setGear(String s, int i) {
        gears[i] = new Gear(s);
    }
    public void rotate(int idx, int dir) {
        if(isValidate(idx+1) && (gears[idx].getRight() != gears[idx+1].getLeft())) {
            rightRotate(idx+1, dir * -1); 
        }
        if(isValidate(idx-1) && (gears[idx].getLeft() != gears[idx-1].getRight())) {
            leftRotate(idx-1, dir * -1);
        }
        roll(idx, dir);
    }
    public int solve() {
        int score = 0;
        for(int i = 0, j = 1; i < 4; ++i, j *= 2)
            if(gears[i].getTop())
                score += j;
        return score;
    }

    private boolean isValidate(int idx) {
        return 0 <= idx && idx < 4;
    }
    private void roll(int idx, int dir) {
        if(dir == 1) {
            gears[idx].rotateRight();
        }else {
            gears[idx].rotateLeft();
        }
    }
    private void rightRotate(int idx, int dir) {
        if(isValidate(idx+1) && (gears[idx].getRight() != gears[idx+1].getLeft())) {
            rightRotate(idx+1, dir * -1); 
        }
        roll(idx, dir);
    }
    private void leftRotate(int idx, int dir) {
        if(isValidate(idx-1) && (gears[idx].getLeft() != gears[idx-1].getRight())) {
            leftRotate(idx-1, dir * -1);
        }
        roll(idx, dir);
    }
}

public class Baekjoon14891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem();
        StringTokenizer st;
        int roll;

        for(int i = 0; i < 4; ++i) {
            problem.setGear(br.readLine(), i);
        }
    
        roll = Integer.parseInt(br.readLine());
        for(int i = 0; i < roll; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.rotate(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }

        System.out.println(problem.solve());
    }
}
