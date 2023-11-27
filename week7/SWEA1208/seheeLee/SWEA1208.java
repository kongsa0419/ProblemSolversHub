import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1208 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1 ; i< 11 ; i++) {
            int dumpNum = Integer.parseInt(br.readLine());
            String[] boxH = br.readLine().split(" ");
            int[] boxHeight  = stringToint(boxH.clone());
            System.out.println("#"+ i + " " + flatten(dumpNum, boxHeight.clone()));
        }
        
        

    }

    private static int flatten(int dumpNum,int[] boxHeight) {
        Arrays.sort(boxHeight);
        for(int i = 0 ; i<dumpNum; i++) {
            if(boxHeight[boxHeight.length-1] > boxHeight[0]){
                boxHeight[boxHeight.length-1]--;
                boxHeight[0]++;
            }
            else if(boxHeight[boxHeight.length-1] == boxHeight[0]){
                break;
            }
            Arrays.sort(boxHeight);
        }
        return boxHeight[boxHeight.length-1]-boxHeight[0];
    }

    private static int[] stringToint(String[] input) {
        int[] boxHeight = new int[input.length];
        for(int i = 0 ; i<input.length; i++) {
            boxHeight[i] = Integer.parseInt(input[i]);
        }
        return boxHeight;
    }
}
