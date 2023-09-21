import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
}


public class Beakjoon4963 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w =-1;
        int h =-1;
        Stack<Location> stac = new Stack<>();

        while((w != 0 && h !=0)){
            String[] input = br.readLine().split(" "); 
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            int start_x = -1;
            int start_y = -1;

            if((w==0) && (h==0))
            {
                return;
            }

            
            int count =0 ;
            int[][] map = new int[h][w];
            boolean[][] map_bool =new boolean[h][w];

            for(int i = 0; i< h ; i++){
                String[] input1 = br.readLine().split(" ");  
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(input1[j]);
                    map_bool[i][j] = false;
                }
            }
            int[] move_ud = {1,-1, 0, 0, 1, -1, 1, -1};  //i 
            int[] move_rl ={0, 0, 1,-1, 1, -1,-1,  1};  //j
            //아래,위,오른쪽,왼쪽,오른쪽아래,왼쪽위,왼쪽아래,오른쪽위

            //맵 전체 탐색 
            for(int i=0; i < h ; i++){
                for(int j=0; j < w; j++){
                    //땅 찾으면
                    if((map[i][j]==1) && ( map_bool[i][j]==false)){
                        start_x = i;
                        start_y = j;
                        stac.push(new Location(start_x, start_y));
                        while(!stac.isEmpty()){
                             //방문 완료
                            Location location = stac.pop();
                            start_x = location.x;
                            start_y = location.y;
                            
                            //8방향 탐색해서 나와
                            for(int k=0 ; k<8 ; k++){ //8방향
                                if(((start_x + move_ud[k])>=0) && ((start_y + move_rl[k])>=0) && 
                                    ((start_x + move_ud[k]) < h) &&  ((start_y + move_rl[k]) < w) &&
                                    (map[start_x + move_ud[k]][start_y+move_rl[k]]==1) && 
                                    map_bool[start_x + move_ud[k]][start_y+move_rl[k]] == false ){
                                    stac.push(new Location(start_x + move_ud[k], start_y + move_rl[k]));
                                }
                            }
                            map_bool[start_x][start_y] = true;

                        }
                        count++;
                    }
                }
            }
            //만약 땅이 없을 경우
            if(start_x == -1 && start_y==-1){
                System.out.println(0);
            }
            else{
                System.out.println(count);
            }

        }

    }
}