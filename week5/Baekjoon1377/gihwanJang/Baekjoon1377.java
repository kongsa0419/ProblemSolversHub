import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int val, idx;
    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
    @Override
    public int compareTo(Pair o){
        return val - o.val;
    }
}

public class Baekjoon1377 {
    public int solve(Pair[] nums, int n){
        int ret = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; ++i) 
            ret = Math.max(ret, nums[i].idx - i);
        return ret + 1;
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon1377 problem = new Baekjoon1377();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] nums = new Pair[n];
        for(int i = 0; i < n; ++i) {nums[i] = new Pair(Integer.parseInt(br.readLine()), i);}
        System.out.println(problem.solve(nums, n));
    }
}