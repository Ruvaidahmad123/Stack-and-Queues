import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> ngeMap = new HashMap<>(); // Map to store next greater elements
        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            // Pop elements from stack while they are smaller or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            // If stack is empty, there is no next greater element for the current element
            if (stack.isEmpty()) {
                ngeMap.put(num, -1);
            } else {
                ngeMap.put(num, stack.peek());
            }
            // Push the current element onto the stack
            stack.push(num);
        }
        // Prepare the result array for nums1 using the map of next greater elements
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.get(nums1[i]);
        }
        return result;
    }
}