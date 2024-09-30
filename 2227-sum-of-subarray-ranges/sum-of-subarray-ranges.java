class Solution {
    public int[] prevGreaterEqualElementIndex(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] nextGreaterElementIndex(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] prevSmallerEqualElementIndex(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmallerElementIndex(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prev = prevSmallerEqualElementIndex(arr, n);
        int[] next = nextSmallerElementIndex(arr, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum = (sum + (left * right * arr[i]));
        }
        return sum;
    }
    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] prev = prevGreaterEqualElementIndex(arr, n);
        int[] next = nextGreaterElementIndex(arr, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum = (sum + (left * right * arr[i]));
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        long max=sumSubarrayMaxs(nums);
        long min=sumSubarrayMins(nums);
        return max-min;
    }
}