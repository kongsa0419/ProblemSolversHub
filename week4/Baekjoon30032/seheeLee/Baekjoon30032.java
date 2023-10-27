import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon30032 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int reversal = Integer.parseInt(input[1]);
        char[][] alpha = new char[][]{{'b','d','p'}
        ,{'d','b','q'}
        ,{'q','p','d'}
        ,{'p','q','b'}};       
        for(int i =0 ; i<n ;i++ ){
            char[] answer = new char[n];
            String inputStrings = br.readLine();
            char[] inputStrings1 = inputStrings.toCharArray();
            for(int j = 0 ; j < inputStrings1.length ; j++){
                if(inputStrings1[j]=='b' && reversal==1 )answer[j] = alpha[0][2];
                else if(inputStrings1[j]=='d' && reversal==1 )answer[j] = alpha[1][2];
                else if(inputStrings1[j]=='q' && reversal==1 )answer[j] = alpha[2][2];
                else if(inputStrings1[j]=='p' && reversal==1 )answer[j] = alpha[3][2];
                else if(inputStrings1[j]=='b' && reversal==2 )answer[j] = alpha[0][1];
                else if(inputStrings1[j]=='d' && reversal==2 )answer[j] = alpha[1][1];
                else if(inputStrings1[j]=='q' && reversal==2 )answer[j] = alpha[2][1];
                else if(inputStrings1[j]=='p' && reversal==2 )answer[j] = alpha[3][1];
            }
            System.out.println(String.valueOf(answer));
        }
        
    }
}
