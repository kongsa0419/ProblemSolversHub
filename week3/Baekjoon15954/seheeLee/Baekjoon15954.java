import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15954 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int window =Integer.parseInt(st.nextToken());
        int[] dollList = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n; i++){
            dollList[i] = Integer.parseInt(st.nextToken());
        }
        solve(dollList,window);
    }
    static void solve(int[] dollList, int window){
        double min = Double.MAX_VALUE;
        while(window<=dollList.length){
            for(int i =0 ; i<dollList.length+(1-window);i++){
                double std = standardDeviation(i,i+(window),dollList);
                if(std<min) min = std;
            }
            window++;
        }
        System.out.println(min);
    }

    static double standardDeviation(int s, int e, int[] dollList){
        double avg=0.0;
        double std = 0.0;
        for(int i =s; i< e; i++){
            avg+=dollList[i];
        }
        avg = (avg/(e-s));
        for(int i =s; i< e; i++){
            std += Math.pow((dollList[i]-avg),2);
        }
        std = Math.sqrt((std/(e-s)));
        return std;
    }


}