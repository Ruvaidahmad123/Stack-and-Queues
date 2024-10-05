class Solution {
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    static String postToPre(String post_exp) {
        // code here
         Stack<String> st = new Stack<>();

        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);

            // If the character is an operand, push it to the stack.
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");
            }
            // If the character is an operator, pop two operands from the stack,
            // combine them in prefix order and push the result back to the stack.
            else if (isOperator(ch)) {
                String operand2 = st.pop();
                String operand1 = st.pop();
                String subExp = ch + operand1 + operand2;  // Form the prefix expression
                st.push(subExp);
            }
        }

        // The final result will be the only element left in the stack.
        return st.pop();

    }
}
