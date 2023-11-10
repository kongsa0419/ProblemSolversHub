
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Baekjoon28292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        antSequence(Integer.parseInt(n));
    }
    public static void antSequence(int n) {
        List<Character> sequence = new ArrayList<>();
        List<Character> sequence_copy = new ArrayList<>();
        sequence.add('1');
        for(int i = 0 ; i < (n-1); i++) {
            sequence_copy.clear();
            sequence_copy.addAll(sequence);
            sequence.clear();
            int count=1;
            sequence.add(sequence_copy.get(0));
            for(int j = 0 ; j < sequence_copy.size(); j++){
                if(((j+1) < sequence_copy.size()) && sequence_copy.get(j).equals(sequence_copy.get(j+1))){
                    count++;
                }
                else if(((j+1) < sequence_copy.size())){
                    sequence.add(Integer.toString(count).charAt(0));
                    sequence.add(sequence_copy.get(j+1));
                    count=1;
                }
            }
            sequence.add(Integer.toString(count).charAt(0));
        }
        List<Integer> result = new ArrayList<>();
        for (Character character : sequence) {
            result.add(Integer.parseInt(Character.toString(character)));
        }
        result.sort(Comparator.reverseOrder());
        System.out.println(result.get(0));
    }
    
}
