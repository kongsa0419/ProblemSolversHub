package Baekjoon10775.seheeLee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon10775{
    public static void main(String[] args)  throws IOException{

        //게이트수만큼 받고, 2차원배열로 밑에 들어가야할 우선순위를 내림차순으로 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gate_num = Integer.parseInt(br.readLine());  //4
        int airplane_num = Integer.parseInt(br.readLine()); //3 
        int count =0;

        int[] airplane = new int[gate_num];
        for(int c= 0 ; c<gate_num; c++){
            airplane[c] = c;
        }

        int[] g = new int[airplane_num];

        //입력 모두 받기
        for(int u = 0 ; u < airplane_num; u++){
            g[u] = Integer.parseInt(br.readLine())-1;
        }

        for(int j=0; j<airplane_num; j++){
            if(count >= gate_num) break;
            int gi = g[j];
            if(airplane[gi] == gi){
                //만약 자기 자신이라면 넣을 수 있다.
                airplane[gi]=gi-1;
                count++;
            }
            else if(gi-1>=0){  //자신노드가 다른 집합에 속해있을 때 
                int possible = find_union(gi,airplane);
                if(possible == -2){ //인덱스를 벗어날 경우 
                    break;
                }
                if(possible>=0){
                    airplane[possible] = possible-1;
                    count++;
                }
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }


    static int find_union(int node, int[] airplane){
        if(node > -1){  
            if(airplane[node] == node){ return node ;}
            airplane[node] = find_union(airplane[node], airplane);
            return airplane[node];
        }
        else{
            return -2;
        }
        
    }
}