import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon28290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.equals("fdsajkl;")|| input.equals("jkl;fdsa")) System.out.println("in-out");
        else if(input.equals("asdf;lkj")|| input.equals(";lkjasdf")) System.out.println("out-in");
        else if(input.equals( "asdfjkl;")) System.out.println("stairs");
        else if(input.equals(";lkjfdsa")) System.out.println("reverse");
        else System.out.println("molu");
    }
}
