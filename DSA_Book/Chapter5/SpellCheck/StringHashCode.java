package SpellCheck;

// create hascodes for strings
public class StringHashCode implements HashCode {

    @Override
    public int giveCode(Object o) {

        // Check if object is a string
        if (o.getClass().getName().equals("java.lang.String")) {

            // Cast object
            String s = (String) o;
            s = s.toLowerCase();

            char stArray[] = s.toCharArray();

            int prod = stArray[stArray.length - 1];
            int i = stArray.length - 2;

            // Prime multiplier
            int a = 241;

            while (i >= 0) {

                prod = (prod * a) + stArray[i];
                i--;
            }

            return prod;
        }
        return 0;
    }

}
