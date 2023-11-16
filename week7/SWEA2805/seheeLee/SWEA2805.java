import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SWEA2805 {

    static int mapSize ;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc ; i++) {
            mapSize = Integer.parseInt(br.readLine());
            int sum=0;
            int mid = mapSize/2;
            for(int r = 0 ; r < mapSize; r++) {
                String[] input  = br.readLine().split("");
                if(r <= mid)  {  
                    for(int c = mid - r ; c < mid + r + 1; c++) {
                        sum += Integer.parseInt(input[c]);
                    }   
                } 
                else{
                    for(int c = Math.abs(mid - r) ; c   <  mapSize - Math.abs(mid - r); c++) {
                        sum += Integer.parseInt(input[c]);
                    }
                }      
            }

            System.out.println("#"+ i +" "+ sum);

        }

        
    }

}