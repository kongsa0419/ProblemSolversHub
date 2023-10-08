
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Room{
    int room_num;
    int s_time ;
    int e_time ;

    public Room(int room_num, int s_time, int e_time){
        this.room_num = room_num;
        this.s_time = s_time;
        this.e_time = e_time;
    }
}


public class Baekjoon30019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Room[] rooms = new Room[M];
        
        for(int i =0; i<M ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int room_num = Integer.parseInt(st.nextToken());
            int s_time = Integer.parseInt(st.nextToken());
            int e_time = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(room_num,s_time,e_time); 
        }
        강의실예약체크(rooms,M,N);
    }  

    static void 강의실예약체크(Room[] rooms,int M, int N ){
        int[] roomlist = new int[N+1]; //1번방 2번방 
        for(int i = 0 ; i < N ; i++){
            roomlist[i] = -1;
        }
        for(int i = 0 ; i < rooms.length; i++){
            if(roomlist[rooms[i].room_num] == -1){
                roomlist[rooms[i].room_num] = rooms[i].e_time;
                System.out.println("YES");
            }
            else if(roomlist[rooms[i].room_num] <= rooms[i].s_time){
                roomlist[rooms[i].room_num] = rooms[i].e_time;
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    

}
