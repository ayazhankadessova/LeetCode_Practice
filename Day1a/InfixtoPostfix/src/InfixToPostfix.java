import java.util.Stack;
public class InfixToPostfix {

    public int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<Character>();
        String postfix = "";

        char ch[] = s.toCharArray();

        for (char c: ch) {
            if (c!= '+' && c!='-' && c!='*' && c!='/' && c!='(' && c!=')') {
                postfix += c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while(!st.isEmpty()) {
                char t = st.pop();
                if(t != '(') {
                    postfix = postfix + t;
                } else {
                    break;
                }
                }
            }
            else if (c== '+' || c=='-' || c=='*' || c=='/' || c=='(' || c==')') {
                if (st.isEmpty()) {
                    st.push(c);
                } else {
                    while(!st.isEmpty()) {
                        char t = st.pop();
                        if (t == '(') {
                            st.push(t);
                            break;
                        } else if (t== '+' || t=='-' || t=='*' || t=='/') {
                            // if priority not 
                            if (getPriority(t) < getPriority(c)) {
                                st.push(t);
                                break;
                            } else {
                                postfix = postfix+t;
                            }
                        }
                    }
                    st.push(c);
                }
            }
        }
        while(!st.isEmpty()) {
      postfix = postfix + st.pop();
    }
    return postfix;


    }
    public static void main(String[] args) {
    InfixToPostfix a = new InfixToPostfix();
    String s1 = a.infixToPostfix("2+3-1");
    System.out.println(s1);
    
    String s2 = a.infixToPostfix("2+3*4");
    System.out.println(s2);
    
    String s3 = a.infixToPostfix("3*(4+5)-6/(1+2)");
    System.out.println(s3);
  }
}
