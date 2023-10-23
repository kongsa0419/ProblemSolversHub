import java.io.*;

public class Baekjoon30023 {
    private int[] convert(String s, int n) {
        int[] leds = new int[n];

        for(int i = 0; i < n; ++i) {
            if(s.charAt(i) == 'R') leds[i] = 0;
            else if(s.charAt(i) == 'G') leds[i] = 1;
            else leds[i] = 2;
        }
        
        return leds;
    }

    private int makeSameLeds(int[] leds, int color) {
        int count = 0;
        int size = leds.length;

        for(int i = 0; i < size-2; ++i) {
            while(leds[i] != color) {
                ++count;
                for(int j = 0; j < 3; ++j)
                    leds[i + j] = (leds[i + j] + 1) % 3;
            }
        }

        if(leds[size-1] == color && leds[size-2] == color) return count;
        return Integer.MAX_VALUE;
    }

    public int solve(String s, int n) {
        int min = Integer.MAX_VALUE;
        int[] leds = convert(s, n);

        for(int i = 0; i < 3; ++i)
            min = Math.min(min, makeSameLeds(leds.clone(), i));

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon30023 problem = new Baekjoon30023();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(problem.solve(s, n));
    }    
}
