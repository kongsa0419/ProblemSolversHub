import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Baekjoon14503 {

   static int x; 
   static int y;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] inputNM = br.readLine().split(" ");
      int n = Integer.parseInt(inputNM[0]);
      int m = Integer.parseInt(inputNM[1]);

      String[] startPoint = br.readLine().split(" ");
      x = Integer.parseInt(startPoint[0]);
      y = Integer.parseInt(startPoint[1]);
      int direction = Integer.parseInt(startPoint[2]);

      String[][] map  = new String[n][m];

      for(int i = 0; i < n; i++) {
         map[i] = br.readLine().split(" ");
      }
      clean(map.clone(),direction);
   }

   private static void clean(String[][] map, int direction) {
      int cleanCount = 0 ;
      boolean isStuck = false;
      while(!isStuck) { 
         System.out.printf("%d %d %d\n",x,y,direction);
         if(map[x][y].equals("0")) {
            map[x][y] = "2";
            cleanCount++;
         }
         if(map[x-1][y].equals("0") || map[x+1][y].equals("0")|| map[x][y+1].equals("0") || map[x][y-1].equals("0")) {
            do {
               direction = directionChange(direction);
            } while (!canGo(map, direction));
            map[x][y] = "2";
            cleanCount++;
         }else{
            if(!canBackGo(map, direction)){
               isStuck = true;
            }
         }
      }
      System.out.println(cleanCount);
   }

   private static int directionChange(int direction) { 
      if(direction == 0){
         direction = 3;
         return direction;
      }else{
         direction--;
         return direction;
      }
   }
   

   private static boolean canGo(String[][] map ,int direction) {
      if(direction == 0 && map[x-1][y].equals("0") && ((x-1) < map.length)) {
         x--;
         return true;   
      }
      else if(direction == 1 && map[x][y+1].equals("0") && ((y+1)< map[0].length)) {
         y++;
         return true;
      }
      else if(direction == 2  && map[x+1][y].equals("0") && ((x-1) >= 0 ) ) {
         x++;
         return true;
      }
      else if(direction == 3 && map[x][y-1].equals("0") && ((y-1)>=0)) {
         y--;
         return true;
      }
      return false;
   }

   private static boolean canBackGo(String[][] map ,int direction) { 
      if(direction == 0 && map[x+1][y].equals("2") && ((x-1) >=0 )) {
         x++;
         return true;   
      }
      else if(direction == 1 && map[x][y-1].equals("2") && ((y-1) >=0) ) {
         y--;
         return true;
      }
      else if(direction == 2  && map[x-1][y].equals("2")&& ((x+1) < map.length) ) {
        x--; 
         return true;
      }
      else if(direction == 3 && map[x][y+1].equals("2")&& ((y+1) < map[0].length) ) {
         y++;
         return true;
      }
      return false;
   }

   


 

}