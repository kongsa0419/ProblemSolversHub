import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Pair{
    int index;
    long diffValue;
    public Pair(int index, long diffValue) {
        this.index = index;
        this.diffValue = diffValue;
    }
}

public class Baekjoon30022{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int round = Integer.parseInt(st.nextToken());  //round
        int aMax = Integer.parseInt(st.nextToken());   //A상점 
        int bMax = Integer.parseInt(st.nextToken());   //B상점
        long result= 0; //결과
        List<Pair> diffValue = new ArrayList<>(); 
        long[] a = new long[round];  //a상점 목록 
        long[] b = new long[round];  //b상점 목록 
        for(int i=0; i < round ; i++){
            String[] stringP = br.readLine().split(" "); //입력 받기
            long aValue = Long.parseLong(stringP[0]);
            long bValue = Long.parseLong(stringP[1]);
            a[i] = aValue;
            b[i] = bValue;
            diffValue.add(new Pair(i,Math.abs(aValue-bValue)));
        }
        getComparator(diffValue);
        result = extracted(diffValue, a, b, aMax, bMax);
        System.out.println(result);
    }
    
    private static long extracted(List<Pair> diffValue, long[] a, long[] b, int aCount, int bCount) {
        long result=0;
        for(Pair pairElement : diffValue){
            if((a[pairElement.index]<=b[pairElement.index]) ) {
                if(aCount == 0) {
                    result += b[pairElement.index];
                    bCount--;
                }
                else {
                    result += a[pairElement.index];
                    aCount--;
                }
            }else{
                if(bCount == 0) {
                    result += a[pairElement.index];
                    aCount--;
                }
                else {
                    result += b[pairElement.index];
                    bCount--;
                }
            }
        }
        return result;
    }

    private static void getComparator(List<Pair> diffValue) {
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return Long.compare(pair2.diffValue, pair1.diffValue);
            }
        };
        Collections.sort(diffValue, comparator);
    }
}