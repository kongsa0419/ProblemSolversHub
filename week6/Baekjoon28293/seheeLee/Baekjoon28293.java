
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon28293{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input  = br.readLine().split(" ");
        int base = Integer.parseInt(input[0]);
        int sq = Integer.parseInt(input[1]);
        solve(base, sq);
    }
    
    public static void solve(int base, int sq) {
        System.out.println((int)(sq * Math.log10(base)+1));
    }
    

}
