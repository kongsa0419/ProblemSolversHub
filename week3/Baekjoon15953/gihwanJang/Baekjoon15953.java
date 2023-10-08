import java.util.*;
import java.io.*;

class Price {
    int cost;
    int start;
    int end;

    public Price(int cost, int start, int end) {
        this.cost = cost;
        this.start = start;
        this.end = end;
    }
}

public class Baekjoon15953 {
    Price[] firstConstest = new Price[7];
    Price[] secondConstest = new Price[6];

    public void makePrice() {
        firstConstest[0] = new Price(0, -1, 0);
        firstConstest[1] = new Price(5_000_000, firstConstest[0].end, firstConstest[0].end+1);
        firstConstest[2] = new Price(3_000_000, firstConstest[1].end, firstConstest[1].end+2);
        firstConstest[3] = new Price(2_000_000, firstConstest[2].end, firstConstest[2].end+3);
        firstConstest[4] = new Price(500_000, firstConstest[3].end, firstConstest[3].end+4);
        firstConstest[5] = new Price(300_000, firstConstest[4].end, firstConstest[4].end+5);
        firstConstest[6] = new Price(100_000, firstConstest[5].end, firstConstest[5].end+6);

        secondConstest[0] = new Price(0, -1, 0);
        secondConstest[1] = new Price(5_120_000, secondConstest[0].end, secondConstest[0].end+1);
        secondConstest[2] = new Price(2_560_000, secondConstest[1].end, secondConstest[1].end+2);
        secondConstest[3] = new Price(1_280_000, secondConstest[2].end, secondConstest[2].end+4);
        secondConstest[4] = new Price(640_000, secondConstest[3].end, secondConstest[3].end+8);
        secondConstest[5] = new Price(320_000, secondConstest[4].end, secondConstest[4].end+16);
    }

    public int solve(int a, int b) {
        int cost = 0;

        for(int i = 1; i < 7; ++i)
            if(firstConstest[i].start < a && a <= firstConstest[i].end) {
                cost += firstConstest[i].cost;
                break;
            }
        for(int i = 1; i < 6; ++i)
            if(secondConstest[i].start < b && b <= secondConstest[i].end) {
                cost += secondConstest[i].cost;
                break;
            }

        return cost;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon15953 problem = new Baekjoon15953();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int a, b;

        problem.makePrice();
        while(0 < T--) { 
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(problem.solve(a, b)).append("\n");
        }

        System.out.println(sb.toString());
    }
}