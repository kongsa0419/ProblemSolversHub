
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon30021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(giftNumber(n));
    }

    static String giftNumber(int n){
        StringBuilder sb = new StringBuilder();
        if(n==2){
            sb.append("NO");
        }
        else if(n==1){
            sb.append("YES\n");
            sb.append("1");
            return sb.toString();
        }
        else{
            sb.append("YES\n");
            sb.append("1 3 2 ");
            for(int i= 4; i < n+1;i++){
                sb.append(i+" ");
            }
        }
        return sb.toString();
    }
}
