class Solution {
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    static String preToInfix(String pre_exp) {
        // code here
         Stack<String> st = new Stack<>();

        // Traverse the expression from right to left
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);

            // If the character is an operand, push it to the stack.
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");
            }
            // If the character is an operator, pop two operands from the stack,
            // combine them with the operator and push the result back to the stack.
            else if (isOperator(ch)) {
                String operand1 = st.pop();
                String operand2 = st.pop();
                String subExp = "(" + operand1 + ch + operand2 + ")";
                st.push(subExp);
            }
        }

        // The final result will be the only element left in the stack.
        return st.pop();
    }
}
