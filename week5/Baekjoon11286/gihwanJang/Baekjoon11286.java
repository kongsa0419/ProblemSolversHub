import java.io.*;
import java.util.*;

class Value implements Comparable <Value> {
    int value;
    public Value(int value){this.value = value;}
    @Override
    public int compareTo(Value o) {
        if(Math.abs(value) == Math.abs(o.value))
            return value - o.value;
        return Math.abs(value) - Math.abs(o.value);
    }
}

public class Baekjoon11286 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        PriorityQueue<Value> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while((n--) > 0) {
            int q = Integer.parseInt(br.readLine());
            if(q == 0)
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll().value);
            else pq.add(new Value(q));
        }
    }
}
