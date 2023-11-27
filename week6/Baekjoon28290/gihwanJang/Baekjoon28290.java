import java.io.*;
import java.util.*;

public class Baekjoon28290 {
    Map<String, String> map;

    public Baekjoon28290() {
        map = new HashMap<>(5);
        map.put("fdsajkl;", "in-out");
        map.put("jkl;fdsa", "in-out");
        map.put("asdf;lkj", "out-in");
        map.put(";lkjasdf", "out-in");
        map.put("asdfjkl;", "stairs");
        map.put(";lkjfdsa", "reverse");
    }

    public String solve(String s) {
        return map.containsKey(s) ? map.get(s) : "molu";
    }

    public static void main(String[] args) throws IOException {
        Baekjoon28290 problem = new Baekjoon28290();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(problem.solve(br.readLine()));
    }
}