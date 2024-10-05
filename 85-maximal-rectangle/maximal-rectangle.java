class Solution {
    public int largesthist(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maxA = 0;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[i] < arr[st.peek()])) {
                int height = arr[st.pop()];
                int width;
                if (st.isEmpty()) {
                    width = i; // Full width if the stack is empty
                } else {
                    width = i - st.peek() - 1;
                }
                maxA = Math.max(width * height, maxA);
            }
            st.push(i);
        }
        return maxA;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] pre = new int[m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    pre[j] += 1; // Accumulate heights
                } else {
                    pre[j] = 0; // Reset height for '0'
                }
            }
            ans = Math.max(ans, largesthist(pre));
        }
        return ans;
    }
}
