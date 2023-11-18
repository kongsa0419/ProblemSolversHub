import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon14891 {
    static List<Gear> gears = new ArrayList<>();

    static class Gear {
        int[] gear;
        boolean isRotate;

        public Gear(int[] gear, boolean isRotate) {
            this.gear = gear;
            this.isRotate = isRotate;
        }
    }
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstGear = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        gears.add(new Gear(firstGear, false));
        int[] secondGear = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        gears.add(new Gear(secondGear, false));
        int[] thirdGear = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        gears.add(new Gear(thirdGear, false));
        int[] fourGear = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        gears.add(new Gear(fourGear, false));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i < n; i++) {
            int[] rotateInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            visited = new boolean[4];
            solve(rotateInfo[0]-1,rotateInfo[1]);
        }
        System.out.println(calculatePoint());
    }   

    private static void solve(int selectGear, int direct){
        subRotate(selectGear, direct);
        rotateGear(selectGear, direct);
    }

    private static void rotateGear(int selectGear, int direct) {
        
        Gear select = gears.get(selectGear);

        if(direct == -1) {
            //반시계 방향으로 밀기
            int tmp = select.gear[0];
            for(int i = 0;i < select.gear.length-1;i++){
                select.gear[i] = select.gear[i+1];
            }
            select.gear[select.gear.length-1] = tmp;
            select.isRotate = true;
        }
        else if(direct == 1){
            int tmp = select.gear[select.gear.length-1];
            for(int i = select.gear.length-1; i > 0; i--){
                select.gear[i] = select.gear[i-1];
            }
            select.gear[0] = tmp;
            select.isRotate = true;
        }
    }

    private static void subRotate(int selectGear , int direct){
        leftSide(selectGear-1 ,-direct);
        rightSide(selectGear+1, -direct);
    }

    private static void leftSide(int selectGear , int direct) {
        if(selectGear < 0) return;
        if(gears.get(selectGear).gear[2]==gears.get(selectGear+1).gear[6]) return;
        leftSide(selectGear-1, -direct);
        rotateGear(selectGear, direct);
    }

    private static void rightSide(int selectGear , int direct) {
        if(selectGear>3) return;
        if(gears.get(selectGear).gear[6] == gears.get(selectGear-1).gear[2]) return;
        rightSide(selectGear+1, -direct);
        rotateGear(selectGear, direct);
    }


    private static int calculatePoint() {
        int result=0;
        int bonus=1;
        for (Gear gear : gears) {
            System.out.println(Arrays.toString(gear.gear));
            if(gear.gear[0] == 1){
                result += bonus;
            }
            bonus *= 2; 
        }
        return result;
    }
}
