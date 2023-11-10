import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Baekjoon28289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalStudent = Integer.parseInt(br.readLine());
        Map<Department, Integer> divisionClass = new  LinkedHashMap<>();
        divisionClass.put(Department.SOFTWARE, 0);
        divisionClass.put(Department.EMBEDDED, 0);
        divisionClass.put(Department.AI, 0);
        divisionClass.put(Department.NOTHING, 0);

        for (int i = 0; i < totalStudent; i++) {
            String[] infoStrings = br.readLine().split(" ");
            divisionClass(divisionClass, Integer.parseInt(infoStrings[0]),
                    Integer.parseInt(infoStrings[1]));
        }

        for (Entry<Department, Integer> a : divisionClass.entrySet()) {
            System.out.println(a.getValue());
        }

    }

    private static void divisionClass(Map<Department, Integer> map, int grade, int clas) {
        if (grade == 1) {
            map.put(Department.NOTHING, map.get(Department.NOTHING) + 1);
        } else if((grade == 2) || (grade == 3)) {
            if ((clas == 1) || (clas == 2)){
                map.put(Department.SOFTWARE, map.get(Department.SOFTWARE) + 1);
            } else if (clas == 3){
                map.put(Department.EMBEDDED, map.get(Department.EMBEDDED) + 1);
            } else if (clas == 4) {
                map.put(Department.AI, map.get(Department.AI) + 1);
            }
        }
    }

    public enum Department {
        SOFTWARE,
        EMBEDDED,
        AI,
        NOTHING
    }
}
