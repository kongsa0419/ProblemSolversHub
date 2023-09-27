package Baekjoon17204.seheeLee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon17204{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int younggi = Integer.parseInt(input[1]);
        
        int next_num = -1; 
        int count =0;
        int[] arr_num = new int[n+1];
        for(int j =0 ; j<n ; j++){
            arr_num[j] = Integer.parseInt(br.readLine());
        }

        arr_num[n] = -1; //마지막 원소에 -1 대입 
        next_num = arr_num[0];   //시작 보성이
        count++;
        for(int i =1 ; i<= n ; i++){
            if(next_num==younggi){
                break;
            }
            next_num = arr_num[next_num];
            count++;
            
        }
        if(count > n){
            System.out.println(-1);
        }else{System.out.println(count);}

        
    }
}