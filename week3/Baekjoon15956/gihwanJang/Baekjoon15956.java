import java.util.*;
import java.io.*;

class UnionFind {
    int[] table;
    int size;

    public UnionFind(int size) {
        this.size = size;
        table = new int[size];

        for(int i = 0; i < size; ++i)
            table[i] = i;
    }

    public int find(int a) {
        if(a == table[a]) return a;
        return table[a] = find(table[a]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        table[rootA] = rootB;
    }
}

public class Baekjoon15956 {
    private String[][] getConditionalExpression(String input) {
        String[] temp;
        String[] andSplit = input.split("&&");
        String[][] condExp = new String[andSplit.length][3];
        for(int i = 0; i < andSplit.length; ++i)
            for(int j = 0; j < andSplit[i].length(); ++j) {
                if(andSplit[i].charAt(j) == '!'){
                    temp = andSplit[i].split("!=");
                    condExp[i][0] = temp[0];
                    condExp[i][1] = temp[1];
                    condExp[i][2] = "!=";
                    break;
                }
                if(andSplit[i].charAt(j) == '='){
                    temp = andSplit[i].split("==");
                    condExp[i][0] = temp[0];
                    condExp[i][1] = temp[1];
                    condExp[i][2] = "==";
                    break;
                }
            }
        return condExp;
    }

    private Map<String,Integer> getVariable(String[][] condExp) {
        Map<String,Integer> variable = new HashMap<>(condExp.length*2);
        for(int i = 0, j= 0; i < condExp.length; ++i)
            for(int k = 0; k < 2; ++k)
                if(!variable.containsKey(condExp[i][k]))
                    variable.put(condExp[i][k], j++);
        return variable;
    }

    private Map<Integer,String> getRevVariable(Map<String,Integer> variable) {
        Map<Integer,String> revVariable = new HashMap<>(variable.size());
        for(Map.Entry<String, Integer> v : variable.entrySet())
            revVariable.put(v.getValue(), v.getKey());
        return revVariable;
    }

    public String solve(String input) {
        StringBuilder sb = new StringBuilder();
        String[][] condExp = getConditionalExpression(input);
        Map<String,Integer> variable = getVariable(condExp);
        Map<Integer,String> revVariable = getRevVariable(variable);
        UnionFind eqaulSet = new UnionFind(variable.size());
        UnionFind nonEqaulSet = new UnionFind(variable.size());

        for(String[] exp : condExp){
            if(exp[2] == "=="){
                int a = revVariable.get(eqaulSet.find(variable.get(exp[0]))).length();
                int b = revVariable.get(eqaulSet.find(variable.get(exp[1]))).length();
                if(a < b)
                    eqaulSet.union(variable.get(exp[0]), variable.get(exp[1]));
                else
                    eqaulSet.union(variable.get(exp[1]), variable.get(exp[0]));
            }
            else {
                int a = revVariable.get(nonEqaulSet.find(variable.get(exp[0]))).length();
                int b = revVariable.get(nonEqaulSet.find(variable.get(exp[1]))).length();
                if(a < b)
                    nonEqaulSet.union(variable.get(exp[0]), variable.get(exp[1]));
                else
                    nonEqaulSet.union(variable.get(exp[1]), variable.get(exp[0]));
            }
        }

        for(int i = 0; i < eqaulSet.size; ++i)
            if(eqaulSet.find(i) != i) {
                if(sb.length() != 0) sb.append("&&");
                sb.append(revVariable.get(i));
                sb.append("==");
                sb.append(revVariable.get(eqaulSet.find(i)));
            }
        for(int i = 0; i < nonEqaulSet.size; ++i)
            if(nonEqaulSet.find(i) != i) {
                if(sb.length() != 0) sb.append("&&");
                sb.append(revVariable.get(i));
                sb.append("!=");
                sb.append(revVariable.get(nonEqaulSet.find(i)));
            }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon15956 problem = new Baekjoon15956();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(problem.solve(input));
    }
}