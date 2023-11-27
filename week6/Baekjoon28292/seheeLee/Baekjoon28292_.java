
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baekjoon28292_ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n<=2) System.out.println(1);
        else if(n>2 && n<=5) System.out.println(2);
        else{ 
            System.out.println(3);
        }
    }
}