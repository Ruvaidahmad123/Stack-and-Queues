class Solution {
    // Function to return precedence of operators.
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Helper function to reverse the string and also swap parentheses.
    public static String reverseExpression(String exp) {
        StringBuilder reversed = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                reversed.append(')');
            } else if (ch == ')') {
                reversed.append('(');
            } else {
                reversed.append(ch);
            }
        }
        return reversed.toString();
    }

    // Function to convert an infix expression to a prefix expression.
    public static String infixToPrefix(String exp) {
        // Step 1: Reverse the infix expression.
        exp = reverseExpression(exp);
        
        String result = "";
        Stack<Character> st = new Stack<>();
        int n = exp.length();

        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);

            // If the character is an operand, add it to the result.
            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            }
            // If the character is '(', push it to the stack.
            else if (ch == '(') {
                st.push(ch);
            }
            // If the character is ')', pop and add to result until '(' is encountered.
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result += st.pop();
                }
                st.pop(); // Remove the '(' from the stack.
            }
            // An operator is encountered.
            else {
                // Pop from stack while precedence of current operator is less than or equal to stack's top.
                while (!st.isEmpty() && Prec(ch) <= Prec(st.peek())) {
                    // For '^' operator, we need right-to-left associativity, hence use less-than for '^'.
                    if (ch == '^' && st.peek() == '^') {
                        break;
                    }
                    result += st.pop();
                }
                st.push(ch);
            }
        }

        // Pop all remaining operators from the stack.
        while (!st.isEmpty()) {
            result += st.pop();
        }

        // Step 4: Reverse the result to get the final prefix expression.
        return new StringBuilder(result).reverse().toString();
    }

    // Example usage:
    public static void main(String[] args) {
        String infix = "(a-b/c)*(a/k-l)";
        System.out.println("Prefix expression: " + infixToPrefix(infix));
    }
}
