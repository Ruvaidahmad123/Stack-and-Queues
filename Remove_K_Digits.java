import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        // Stack to store the digits of the smallest number
        Stack<Character> stack = new Stack<>();
        
        // Traverse each digit in the number
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            
            // Remove digits from the stack while the current digit is smaller
            // and k > 0 (i.e., we still need to remove digits)
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--; // One digit is removed
            }
            
            // Push the current digit to the stack
            stack.push(digit);
        }
        
        // If there are still digits to remove, remove them from the end
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build the smallest number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        // Reverse the string since we built it from the stack
        sb.reverse();
        
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        // If the result is empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
