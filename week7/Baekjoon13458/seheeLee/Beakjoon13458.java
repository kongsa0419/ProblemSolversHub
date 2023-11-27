import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beakjoon13458 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testPlaceNum = Integer.parseInt(br.readLine());
        
        String[] examinessStr = br.readLine().split(" ");
        int[] examiness = Arrays.stream(examinessStr).mapToInt(Integer::parseInt).toArray();

        String[] observerStr = br.readLine().split(" ");
        int generalManager = Integer.parseInt(observerStr[0]);
        int subManager = Integer.parseInt(observerStr[1]);
        
        System.out.println(solve(examiness, generalManager, subManager));
        br.close();
    }

    private static long solve(int[] examiness, int generalManager, int subManager) {
        long result =0;
        for(int i = 0 ; i < examiness.length; i++) {
            examiness[i] = examiness[i] - generalManager;
            result++;
            if(examiness[i]>0){
                double tmp = examiness[i];
                double stmp = subManager;
                result += Math.ceil(tmp/stmp);
            }
        }
        return result;
    }
    
}
