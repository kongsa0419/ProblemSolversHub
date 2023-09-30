import java.io.*;
import java.util.*;

class Reservation {
    int roomNum, start, end;

    public Reservation(int roomNum, int start, int end) {
        this.roomNum = roomNum;
        this.start = start;
        this.end = end;
    }
}

public class Baekjoon30019 {
    public String solve(Reservation[] reservations, int n, int m) {
        int idx;
        int[] roomLists = new int[n];
        StringBuilder ans = new StringBuilder();

        Arrays.fill(roomLists, -1);

        for(int i = 0; i < m; ++i){
            idx = reservations[i].roomNum;
            if(roomLists[idx] != -1 && reservations[i].start < reservations[roomLists[idx]].end){
                    ans.append("NO\n");
            }
            else {
                ans.append( "YES\n");
                roomLists[idx] = i;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30019 problem = new Baekjoon30019();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Reservation[] reservations = new Reservation[m];

        for(int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int roomNum = Integer.parseInt(st.nextToken())-1;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reservations[i] = new Reservation(roomNum, start, end);
        }

        System.out.println(problem.solve(reservations, n, m));
    }
}
