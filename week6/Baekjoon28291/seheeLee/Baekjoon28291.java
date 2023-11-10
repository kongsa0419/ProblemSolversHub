import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Baekjoon28291 {
    static int[][] map;
    static int[][] map_clone;
    static List<Position> lampPositions = new ArrayList<>();
    static Stack<Position> stc = new Stack<>();

    public static class Position {
        int x; 
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");
        int n = Integer.parseInt(mapSize[0]);
        int m = Integer.parseInt(mapSize[1]);
        map = new int[n][m];
        map_clone = new int[n][m];
        int itemNumber = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < itemNumber ; i++) {
            String[] itemPositon = br.readLine().split(" ");
            String item = itemPositon[0].trim();
            int x = Integer.parseInt(itemPositon[1]);
            int y = Integer.parseInt(itemPositon[2]);
            mapInit(item, x, y);
        }

        if(isConnect())System.out.println("success");
        else{System.out.println("failed");}
    }

    public static boolean isConnect() {
        List<Boolean> allOn= new ArrayList<>();
        map = map_clone.clone();
        for (Position position : lampPositions) {
            stc.clear();
            int maxCount = 15; 
            while(maxCount > 0) {
                if(isBlock(position)){
                    allOn.add(true);
                    break;
                }
                if(isMove(position)){
                    maxCount--;
                }
                else if(!stc.empty()) {
                    Position xy = stc.pop();
                    maxCount++;
                    position.x = xy.x;
                    position.y = xy.y;
                }else{
                    return false;
                }
            }
        }
        
        int trueCount = Collections.frequency(allOn, true);
        return trueCount == lampPositions.size();
    }

    public static boolean isMove(Position position) {
        if((position.x+1 < map.length ) &&  map[position.x+1][position.y] == 2 ) { 
            map[position.x+1][position.y] = 5;
            stc.add(new Position(position.x+1, position.y));
            position.x++;
            return true;
        }
        if((position.x-1 >= 0 ) && map[position.x-1][position.y] ==2) { 
            map[position.x-1][position.y] = 5;
            stc.add(new Position(position.x-1, position.y));
            position.x--;
            return true;
        }
        if(((position.y+1) < map[0].length ) && map[position.x][position.y+1] ==2) { 
            map[position.x][position.y+1] = 5;
            stc.add(new Position(position.x, position.y+1));
            position.y++;
            return true;
        }
        if((position.y-1 >=0 ) && map[position.x][position.y-1] ==2) { 
            map[position.x][position.y-1] = 5; //visited 
            stc.add(new Position(position.x, position.y-1));
            position.y--;
            return true;
        }
        return false;
    }

    private static boolean isBlock(Position position) {
        if((position.x+1 < map.length ) && map[position.x+1][position.y] == 1) return true;
        if((position.x-1 >= 0 ) && map[position.x-1][position.y] == 1) return true;
        if(((position.y+1) < map[0].length ) && map[position.x][position.y+1] == 1) return true;
        if((position.y-1 >=0 ) && map[position.x][position.y-1] == 1) return true;
        return false;
    }

    private static void mapInit(String item, int x, int y){ 
        //0 empty //1 block  //2redstone_dust //3 off_ramp  //5 visited 
        if(item.equals("redstone_block")) map_clone[x][y] = 1;
        else if(item.equals("redstone_dust")) map_clone[x][y] = 2;
        else if(item.equals("redstone_lamp")){
            map_clone[x][y] = 3;
            lampPositions.add(new Position(x, y));
        }
    }

}
