class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int nge[]=new int[n];
        Arrays.fill(nge,-1);
        Stack<Integer>st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            int idx=i%n;
            while (!st.isEmpty() && st.peek() <= nums[idx]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[idx]=-1;
            } else {
                nge[idx]=st.peek();
            }
            st.push(nums[idx]);
        }
        return nge;
    }
}