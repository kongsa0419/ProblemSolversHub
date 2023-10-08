import java.io.*;
import java.util.*;

public class Baekjoon30017 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int A = Integer.parseInt(st.nextToken()); //패티
        int B = Integer.parseInt(st.nextToken()); //치즈
  
        
        if(B>=A-1) System.out.println(A + (A-1));
        else System.out.println((B+1)+B);
    }       
}
