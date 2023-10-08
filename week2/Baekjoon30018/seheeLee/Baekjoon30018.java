import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Baekjoon30018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr_a  = new int[N];
        int[] arr_b  = new int[N];

        String[] s_arr_a = br.readLine().split(" ");
        String[] s_arr_b = br.readLine().split(" ");

        for(int i = 0; i< N; i++){
            arr_a[i] = Integer.parseInt(s_arr_a[i]);
            arr_b[i] = Integer.parseInt(s_arr_b[i]);
        }
        int result = 0;
        
        for(int i =0 ; i< N ; i++){
            if((arr_a[i] - arr_b[i]) >0){
                result += (arr_a[i] - arr_b[i]);
            }

        }

        System.out.println(result);
        
    }
    
}
