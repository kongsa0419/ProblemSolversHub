import java.io.*;
import java.util.*;

class RobotInfo {
    int r, c, dir;
    int[][] dirs = { 
        { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } 
    };
    public RobotInfo(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
    public void rotate() { this.dir = (this.dir + 1) % 4; }
}
class MapInfo {
    int n, m;
    boolean[][] map;
    public MapInfo(int n, int m) {
        this.n = n;
        this.m = m;
        map = new boolean[n][m];
    }
    public boolean validationLoc(int r, int c) {
        return (
            0 <= r && r < n 
            &&
            0 <= c && c < m
        );
    }
}
class CleanInfo {
    int cleanCount = 0;
    boolean[][] cleaned;
    public CleanInfo(int n, int m) { 
        this.cleaned = new boolean[n][m]; 
    }
}

public class Baekjoon14503 {
    private void clean(MapInfo mapInfo, RobotInfo robotInfo, CleanInfo cleanInfo) {
        int nextR, nextC;

        if(!cleanInfo.cleaned[robotInfo.r][robotInfo.c]) {
            ++cleanInfo.cleanCount;
            cleanInfo.cleaned[robotInfo.r][robotInfo.c] = true;
        }

        for(int i = 1; i <= 4; ++i) {
            nextR = robotInfo.r + robotInfo.dirs[(robotInfo.dir+4-i)%4][0];
            nextC = robotInfo.c + robotInfo.dirs[(robotInfo.dir+4-i)%4][1];

            if(mapInfo.validationLoc(nextR, nextC) && !mapInfo.map[nextR][nextC] && !cleanInfo.cleaned[nextR][nextC]) {
                robotInfo.r = nextR;
                robotInfo.c = nextC;
                robotInfo.dir = (robotInfo.dir+4-i)%4;
                clean(mapInfo, robotInfo, cleanInfo);
                return;
            }
        }

        nextR = robotInfo.r + robotInfo.dirs[(robotInfo.dir + 2) % 4][0];
        nextC = robotInfo.c + robotInfo.dirs[(robotInfo.dir + 2) % 4][1];
        if(mapInfo.validationLoc(nextR, nextC) && !mapInfo.map[nextR][nextC]){
            robotInfo.r = nextR;
            robotInfo.c = nextC;
            clean(mapInfo, robotInfo, cleanInfo);
        }
        return;
    }
    public int solve(MapInfo mapInfo, RobotInfo robotInfo) {
        CleanInfo cleanInfo = new CleanInfo(mapInfo.n, mapInfo.m);
        clean(mapInfo, robotInfo, cleanInfo);
        return cleanInfo.cleanCount;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon14503 problem = new Baekjoon14503();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        RobotInfo robotInfo;
        MapInfo mapInfo;

        mapInfo = new MapInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        robotInfo = new RobotInfo( 
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()), 
            Integer.parseInt(st.nextToken()));

        for(int r = 0; r < mapInfo.n; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < mapInfo.m; ++c) 
                mapInfo.map[r][c] = (st.nextToken().equals("1"));
        }

        System.out.println(problem.solve(mapInfo, robotInfo));
    }
}
