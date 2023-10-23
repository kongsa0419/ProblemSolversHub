import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon30023 {
    public static void main(String[] args)throws IOException {
        Baekjoon30023 baekjoon30023 = new Baekjoon30023();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        baekjoon30023.solve(n,input);
    }
    void solve(int n, String input){
        int[] convertedNumber = new int[input.length()];
        int[] rgbCount = new int[]{0,0,0};
        convertNumber(convertedNumber,input);
        for(int i = 0; i<3; i++){
            convertSameLed(i, convertedNumber.clone(),rgbCount);
        }
        System.out.println(compareMinCount(rgbCount));
    }
    void convertNumber(int[] convertedNumber ,String input){
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='R')convertedNumber[i]=0;
            if(input.charAt(i)=='G')convertedNumber[i]=1;
            if(input.charAt(i)=='B')convertedNumber[i]=2;
        }
    } 
    void convertSameLed(int color, int[] convertedNumber, int[] rgbCount){
        int arrSize = convertedNumber.length;
        for(int i = 0; i<arrSize-2 ;i++){
            while(convertedNumber[i] != color){
                convertedNumber[i] = (convertedNumber[i]+1)%3 ;
                convertedNumber[i+1] = (convertedNumber[i+1]+1)%3 ;
                convertedNumber[i+2] = (convertedNumber[i+2]+1)%3 ;
                rgbCount[color]++;
            }
        }
        if((convertedNumber[arrSize-2]!=color)||(convertedNumber[arrSize-1]!=color)){rgbCount[color]=Integer.MAX_VALUE;}
    }
    int compareMinCount(int[] rgbCount){
        int min = Integer.MAX_VALUE;
        for(int i =0; i<rgbCount.length;i++){
            if(rgbCount[i]<min)min = rgbCount[i];
        }
        if(min==Integer.MAX_VALUE)min= -1;
        return min;
    }
}
