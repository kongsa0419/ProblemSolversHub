import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11286{
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
        else{ return Math.abs(o1) - Math.abs(o2);}
    });
    void solve(int e){
        if(e==0)
            if(pq.isEmpty()) System.out.println(0);
            else System.out.println(pq.poll());
        else{pq.add(e);}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Baekjoon11286 baekjoon11286 = new Baekjoon11286();
        int n  = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<n; i++){
            baekjoon11286.solve(Integer.parseInt(br.readLine()));
        }
    }
}