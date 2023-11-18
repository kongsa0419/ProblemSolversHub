import java.io.*;
import java.util.*;

class Problem {
    int size;
    int[] nums;

    public Problem(int n) {
        size = n;
        nums = new int[size];
    }

    public long solve(int n) {
        long cnt = size;

        for(int i = 0; i < size; ++i) {
            cnt += nums[i] / n;
            if(nums[i] % n != 0) ++cnt;
        }

        return cnt;
    }

    public void update(int n) {
        for(int i = 0; i < size; ++i) {
            if(nums[i] < n) {
                nums[i] = 0;
            }else {
                nums[i] -= n;
            }
        }
    }
}

public class Baekjoon13458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < problem.size; ++i)
            problem.nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        problem.update(Integer.parseInt(st.nextToken()));

        System.out.println(problem.solve(Integer.parseInt(st.nextToken())));
    }
}