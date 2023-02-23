
class BasicCalculator {

// Approach -> DFS:

// Basic Setup:
// 1. Create a char array to store operands and operators, everything from string value.
// 2. Create an index field to keep track of the current index in the array.
// 3. Call dfs();

// DFS:
// 1. Iterate through the character array
// 2. Start with 0 sum and positive operator (no influence)
// 3. Consider these cases:
//     Case '(' -> need to find res inside the brackets & add it to res w the operator-> call dfs inside the bracket:
//         index++;
//         sum += oper * dfs res
//     Case ')' -> brackets res ended:
//         break;
//     Case '+' / '-' -> set operator to +1/-1;
//     Case digit -> can have multiple digit numbers, so iterate while char is not digit & add to StringBuilder
//     * don't forget index-- here bc we stop on smth which isn't a digit, we need to consider it later

//     all cases considered:
//     Add to sum the number we found from StringBuilder * operator

//     done -> iterate

    char[] toCalculate;
    int i = 0;

    public int calculate(String s) {
        toCalculate = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        int operator = 1;
        int sum = 0;

        // find res inside the brackets & add it to res w the operator
        while (i < toCalculate.length)  {

            if (toCalculate[i] == ')') {
                break;
            } else if (toCalculate[i] == '(') {
                i++;
                sum += operator*dfs();
            } else if(toCalculate[i] == '+') {
                operator = 1;
            } else if (toCalculate[i] == '-') {
                operator = -1;
            } else if (Character.isDigit(toCalculate[i])) { 
                // make a number
                StringBuilder sb = new StringBuilder();
                while(i < toCalculate.length && Character.isDigit(toCalculate[i])) {
                    sb.append(toCalculate[i++]);
                }
                i--;
                // convert to int
                sum += Integer.parseInt(sb.toString()) * operator;
                System.out.println(sum);
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalc = new BasicCalculator();
        System.out.println(basicCalc.calculate("1+(2-(0-3))"));
        // Expected : 3

        BasicCalculator basicCalc2 = new BasicCalculator();
        System.out.println(basicCalc2.calculate(" 2-1 + 2 "));
        // Expected: 3

        BasicCalculator basicCalc3 = new BasicCalculator();
        System.out.println(basicCalc3.calculate("(1+(4+5+2)-3)+(6+8)"));
        // Expected: 23
    }
    
}
