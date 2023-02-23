import java.util.*;

class BasicCalculator {
    public int calculate(String s) {
        int sum = 0;
        s = s.trim();
        int counter = 0;
        int operator = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.compare(s.charAt(i), ' ') != 0 && Character.compare(s.charAt(i), '+') != 0 && Character.compare(s.charAt(i), '-') != 0) {
                int number = s.charAt(i) - '0';
                sum=sum + (number * operator);
                if (operator == -1) {
                    operator =1;
                }
            } else {
                if (Character.compare(s.charAt(i), '-') == 0) {
                    operator = -1;
                }
            }
        }

        
        return sum;
}
}