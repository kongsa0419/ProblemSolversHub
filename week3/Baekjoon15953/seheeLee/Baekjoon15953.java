import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Baekjoon15953{
    public static void main(String[] args) throws IOException {
        Baekjoon15953 baekjoon15953 = new Baekjoon15953();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n ;i++){
            String[] input  = br.readLine().split(" ");
            baekjoon15953.solve(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }
    void solve(int a, int b){
        int reward1 =0;
        int reward2 =0;
        int[][] prizeTable1 = new int[][]{
            {1, 500},{3, 300},{6, 200},{10,50},{15, 30},{21, 10}};
        int[][] prizeTable2 = new int[][]{
            {1, 512},{3, 256},{7, 128},{15,64},{31, 32}};
        for(int i=prizeTable1.length-1; i >=0; i--){
            if(prizeTable1[i][0]>=a && a!=0)reward1=prizeTable1[i][1];
        }
        for(int i=prizeTable2.length-1; i>=0; i--){
            if(prizeTable2[i][0]>=b&& b!=0)reward2=prizeTable2[i][1];
        }
        System.out.println((reward1+reward2)*10000);
    }
}