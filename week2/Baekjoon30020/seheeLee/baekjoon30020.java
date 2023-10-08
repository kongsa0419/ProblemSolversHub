import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon30020 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int patty = Integer.parseInt(st.nextToken());
        int cheese = Integer.parseInt(st.nextToken());
        StringBuilder ans = new StringBuilder();

        ans = checkIngredients(patty, cheese);
        System.out.print(ans.toString());
    }

    static StringBuilder checkIngredients(int patty, int cheese){
        StringBuilder ans = new StringBuilder();
        if((cheese >= patty) || ((patty/2) > cheese)) {
            ans.append("NO");
        }
        else if(patty % 2 == 1 && (patty-3)/2 >(cheese-2)){
            ans.append("NO");
        }
        else{
            ans.append("YES\n");
            ans.append(patty-cheese+"\n");
            while(patty >= 0){
                if((patty-1) == cheese){
                    ans.append(makeCheeseburger(patty, cheese));
                    break;
                }
                patty -=2;
                cheese -=1;
                ans.append("aba\n");
            }
        }
        return ans;
    }
    static String makeCheeseburger(int patty, int cheese) {
        StringBuilder burgur_arr = new StringBuilder();
        for (int a = 0; a < (patty + cheese); a++) {
            if (a % 2 == 0) {
                burgur_arr.append("a");
            } else {
                burgur_arr.append("b");
            }
        }
        return burgur_arr.toString();
    }
}
