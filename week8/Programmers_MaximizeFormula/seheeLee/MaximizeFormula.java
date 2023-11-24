import java.util.ArrayList;

class MaximizeFormula {

    public long cal(long a, long b, char op) {
        if (op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else
            return a * b;
    }

    public void calc(ArrayList<Long> numbers, ArrayList<Character> ops, char op) {
        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) == op) {
                long num1 = numbers.get(i);
                long num2 = numbers.get(i + 1);
                long result = cal(num1, num2, op);
                numbers.remove(i);
                numbers.remove(i); // 위치가 땡겨지므로
                numbers.add(i, result); // 계산된 값을 다시 집어넣는다.
                ops.remove(i); // 연산자는 삭제
                i--;
            }
        }
    }

    public long operation(ArrayList<Long> nums, ArrayList<Character> opers, char op1, char op2, char op3) {
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            numbers.add(nums.get(i));
        }

        for (int i = 0; i < opers.size(); i++) {
            ops.add(opers.get(i));
        }

        calc(numbers, ops, op1);
        calc(numbers, ops, op2);
        calc(numbers, ops, op3);

        return numbers.get(0);
    }

    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        String num = "";
        // 중의 표기법만 고려하기 때문에 -100 이런 것은 없다.
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                operators.add(expression.charAt(i));
                numbers.add(Long.parseLong(num));
                num = "";
            } else {
                num += expression.charAt(i);
            }
        }
        numbers.add(Long.parseLong(num));
        long[] result = new long[6];

        result[0] = operation(numbers, operators, '+', '-', '*');
        result[1] = operation(numbers, operators, '+', '*', '-');
        result[2] = operation(numbers, operators, '-', '+', '*');
        result[3] = operation(numbers, operators, '-', '*', '+');
        result[4] = operation(numbers, operators, '*', '-', '+');
        result[5] = operation(numbers, operators, '*', '+', '-');

        for (int i = 0; i < 6; i++) {
            if (answer < Math.abs(result[i]))
                answer = Math.abs(result[i]);
        }

        return answer;
    }
}