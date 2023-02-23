
class BasicCalculator {

    char[] toCalculate;
    int i = 0;

    public int calculate(String s) {
        toCalculate = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        int operator = 1;
        int sum = 0;

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
                StringBuilder sb = new StringBuilder();
                while(i < toCalculate.length && Character.isDigit(toCalculate[i])) {
                    sb.append(toCalculate[i]);
                    i++;
                }
                i--;

                sum += Integer.parseInt(sb.toString()) * operator;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalc = new BasicCalculator();
        System.out.println(basicCalc.calculate("1+(2-3)"));
    }
    
}
