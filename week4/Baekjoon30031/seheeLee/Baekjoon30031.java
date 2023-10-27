import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon30031 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int money;
        int totalMoney =0;
        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            money = Integer.parseInt(st.nextToken());
            if(money == 136)totalMoney+=1000;
            if(money == 142)totalMoney+=5000;
            if(money == 148)totalMoney+=10000;
            if(money == 154)totalMoney+=50000;
        }
        System.out.println(totalMoney);
    }
}
