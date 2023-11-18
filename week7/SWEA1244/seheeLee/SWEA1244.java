import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class SWEA1244 {
    static int num, move;
    static int[] arr;
    static String str ="";
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());
        //테스트 케이스
        for(int test = 1 ; test<=testNum; test++) { 
            
            //숫자판과 횟수분해 
            String[] temp = br.readLine().split(" ");
            
            //횟수 저장
            move = Integer.parseInt(temp[1]);
            

            //숫자판 저장 
            arr = new int[temp[0].length()];

            if(arr.length < move) {
                move = arr.length;
            }
            //각각의 숫자 저장
            String[] temp2 = temp[0].split("");
            
            //인트형 숫자 리스트 저장
            for(int i = 0; i<arr.length; i++) {
                arr[i] = Integer.parseInt(temp2[i]);
            }
            result =0; 
            dfs(0,0);
            bw.write("#" + test + " " + result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public static void dfs(int k , int cnt) {
        int t;
        if(cnt == move) {
            str = "";
            //스트림
            Arrays.stream(arr).forEach(x-> str += String.valueOf(x));
            result = Math.max(result, Integer.parseInt(str));
            return;
        }

        for(int i = k ; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                t = arr[i]; arr[i] = arr[j]; arr[j] = t; //자리를 바꾼다.
                dfs(i, cnt+1);  //바꿨을 경우로 다시 돌려본다.
                t = arr[i]; arr[i] = arr[j]; arr[j] = t;
                
            }
        }
    }
}
