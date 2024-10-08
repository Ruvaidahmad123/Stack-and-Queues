class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // Build the number
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                // Push the number to the stack
                st.push(sb.toString());
                i--; // Adjust 'i' back to account for skipping the '['
            } else if (s.charAt(i) == ']') {
                // Pop characters until '['
                StringBuilder sb = new StringBuilder();
                while (!st.peek().equals("[")) {
                    sb.insert(0, st.pop());
                }
                // Pop the '['
                st.pop();
                // Get the repetition number
                int num = Integer.parseInt(st.pop());
                // Repeat the string num times
                String repeatedStr = sb.toString().repeat(num);
                // Push the repeated string back to the stack
                st.push(repeatedStr);
            } else {
                // Push the character to the stack
                st.push(String.valueOf(s.charAt(i)));
            }
        }
        // Build the final decoded string
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}
