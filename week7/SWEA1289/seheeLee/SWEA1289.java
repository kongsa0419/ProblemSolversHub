//1289

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= tc; i++) {
            String[] input = br.readLine().split("");
            int count =0 ;
            for(int j = 0 ; j < input.length-1; j++) {
                int current =  Integer.parseInt(input[j]);
                if(j==0 && current ==1) count ++;
                if(j+1 < input.length  && Integer.parseInt(input[j+1]) == current) {
                    continue;
                }else {
                    count++;
                }
            }
            System.out.println("#"+i+" "+count);
        }
    }
}
