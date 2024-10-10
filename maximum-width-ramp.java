class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Create an array to store the maximum values from the right
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        
        // Fill the maxRight array
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int ramp = 0;
        int i = 0;
        int j = 0;

        // Find the maximum width ramp
        while (j < n) {
            while (i < j && nums[i] > maxRight[j]) {
                i++;
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }

        return ramp;
    }
}

2nd approach---->
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty()|| nums[i]<nums[st.peek()]){
                st.push(i);
            }
        }
        int max=0;
        for(int j=nums.length-1;j>=0;j--){
            while(!st.isEmpty() && nums[j]>=nums[st.peek()]){
                max=Math.max(max,j-st.peek());
                st.pop();
            }
        }
        return max;
    }
} 
