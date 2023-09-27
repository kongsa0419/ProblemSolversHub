package Baekjoon30046.seheeLee;

import java.io.IOException;
import java.util.Scanner;

public class Beakjoon30046 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());  //P ,J ,R의 길이 
        String[] find_string={"","",""};
        for(int a = 0; a<3 ; a++){
            find_string[a] = sc.nextLine();
        }
        for(int H = 1; H <= 3 ; H++){
            for(int J=1; J<=3 ; J++){
                for(int S=1; S<=3; S++){
                    if((H!=J) && (J!= S) && (S!=H) && (isPossible(find_string,H,J,S)))
                    {   
                        System.out.println("HJS! HJS! HJS!");
                        return;
                    }
                }
            }
        }
        System.out.println("Hmm...");
        
    }
    static Boolean isPossible(String[] find_string ,int H, int J, int S){
        String[] c = {"","",""};
        for(int i=0 ; i<3 ; i++){
            String a  = find_string[i].replace("H", Integer.toString(H));
            String b  = a.replace("J", Integer.toString(J));
            c[i]  = b.replace("S", Integer.toString(S));
        }

        if(c[0].compareTo(c[1])<0 && c[1].compareTo(c[2])<0){
            return true;
        }
        return false;
    }
}
