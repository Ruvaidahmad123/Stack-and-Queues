class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        // Finding the left smaller elements for each index
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // If stack is empty, there is no smaller element, so assign -1
            leftSmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        // Clear the stack for the next computation
        st.clear();
        // Finding the right smaller elements for each index
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // If stack is empty, there is no smaller element, so assign n
            rightSmall[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        // Calculating the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
