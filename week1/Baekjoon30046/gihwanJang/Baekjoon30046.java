import java.io.*;

public class Baekjoon30046 {
    private char[][] getReplaceSet() {
        char replaceSet[][] = { {'1','2','3'}, {'1','3','2'}, 
                             {'2','1','3'}, {'2','3','1'}, 
                             {'3','1','2'}, {'3','2','1'}, };
        return replaceSet;
    }

    private boolean compare(String p, String q, String r) {
        return (p.compareTo(q) < 0 && q.compareTo(r) < 0);
    }

    public String solve(String pqr[], int n) {
        String yes = "HJS! HJS! HJS!";
        String no = "Hmm...";
        String oneTwoThree[] = new String[3];
        char string[] = new char[n];
        char replace[][] = getReplaceSet();

        for(int i = 0; i < 6; ++i){
            for(int j = 0; j < 3; ++j){
                for(int k = 0; k < n; ++k){
                    if(pqr[j].charAt(k) == 'H') {string[k] = replace[i][0];}
                    else if(pqr[j].charAt(k) == 'J') {string[k] = replace[i][1];}
                    else {string[k] = replace[i][2];}
                }

                oneTwoThree[j] = String.valueOf(string);
            }
            
            if(compare(oneTwoThree[0], oneTwoThree[1], oneTwoThree[2])) {return yes;}
        }

        return no;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30046 problem = new Baekjoon30046();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pqr[] = new String[3];
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < 3; ++i)
            pqr[i] =br.readLine();

        System.out.println(problem.solve(pqr, n));
    }
}