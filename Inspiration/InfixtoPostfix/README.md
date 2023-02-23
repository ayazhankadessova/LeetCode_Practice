<!-- Infix To Postfix -->

https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/

### Using stack and string to convert infix to postfix

1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.

- Else,
  If the precedence and associativity of the scanned operator are greater than the precedence and associativity of the operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), then push it.
- ‘^’ operator is right associative and other operators like ‘+’,’-‘,’\*’ and ‘/’ are left-associative. Check especially for a condition when both, operator at the top of the stack and the scanned operator are ‘^’. In this condition, the precedence of the scanned operator is higher due to its right associativity. So it will be pushed into the operator stack. In all the other cases when the top of the operator stack is the same as the scanned operator, then pop the operator from the stack because of left associativity due to which the scanned operator has less precedence.

- Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)

- If the scanned character is an ‘(‘, push it to the stack.

- If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis.

- Repeat steps 2-6 until the infix expression is scanned.
- Print the output
- Pop and output from the stack until it is not empty.
