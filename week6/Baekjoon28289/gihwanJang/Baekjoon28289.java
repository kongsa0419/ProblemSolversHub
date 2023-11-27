import java.io.*;
import java.util.*;

class Student {int grade, classNum;}

public class Baekjoon28289 {
    Student[] students;

    private int getClassInfo(Student s) {
        if(s.grade == 1) return 3;

        if(s.classNum < 3) {
            return 0;
        } else if(s.classNum == 3) {
            return 1;
        }
        return 2;
    }

    public String solve() {
        int[] classInfo = new int[4];
        StringBuilder sb = new StringBuilder();

        for(Student s : students)
            ++classInfo[getClassInfo(s)];

        for(int i = 0; i < 4; ++i)
            sb.append(classInfo[i]).append("\n");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Baekjoon28289 problem = new Baekjoon28289();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        problem.students = new Student[Integer.parseInt(st.nextToken())];
        for(int i = 0; i < problem.students.length; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.students[i] = new Student();
            problem.students[i].grade = Integer.parseInt(st.nextToken());
            problem.students[i].classNum = Integer.parseInt(st.nextToken());
        }
        
        System.out.print(problem.solve());
    }
}