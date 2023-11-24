class Location {
    int r, c, n;

    public Location(int r, int c, int n) {
        this.r = r;
        this.c = c;
        this.n = n;
    }

    public int getDistance(Location o) {
        return Math.abs(r - o.r) + Math.abs(c - o.c);
    }
}

class Solution {
    String hand;
    Location[] keyPad;
    Location left, right;

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        init(hand);
        for(int n : numbers) {
            press(sb, n);
            display();
        }

        return sb.toString();
    }

    private void init(String hand) {
        this.hand = hand;
        left = new Location(3, 0, -1);
        right = new Location(3, 2, -1);
        keyPad = new Location[10];

        keyPad[0] = new Location(3, 1, 0);
        for(int r = 0, i = 1; r < 3; ++r)
            for(int c = 0; c < 3; ++c, ++i)
                keyPad[i] = new Location(r, c, i);
    }
    private void press(StringBuilder sb, int num) {
        if(num == 0 || num % 3 == 2) {
            midPress(sb, num);
        } else if(num % 3 == 1) {
            sb.append('L');
            left = keyPad[num];
        } else {
            sb.append('R');
            right = keyPad[num];
        }
    }
    private void midPress(StringBuilder sb, int num) {
        int dis =left.getDistance(keyPad[num]) - right.getDistance(keyPad[num]);
        if(dis > 0) {
            sb.append('R');
            right = keyPad[num];
        } else if(dis < 0) {
            sb.append('L');
            left = keyPad[num];
        } else {
            if(hand.compareTo("left") == 0) {
                sb.append('L');
                left = keyPad[num];
            } else {
                sb.append('R');
                right = keyPad[num];
            }
        }
    }
    private void display() {
        System.out.println("left : " + left.n + "  right : " + right.n);
    }
}

public class PressKeypad {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        System.out.println(solution.solution(numbers, "left"));
    }
}