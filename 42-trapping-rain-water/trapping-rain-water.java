class Solution {
    public int trap(int[] height) {
        int res=0;
        int n=height.length;
        int l=0;
        int r=n-1;
        int leftmax=0;
        int rightmax=0;
        while(l<=r){
            if(height[l]<=height[r]){
                if(leftmax<=height[l]){
                    leftmax=height[l];
                }
                else{
                    res+=leftmax-height[l];
                }
                l++;
            }
            else{
                if(rightmax<=height[r]){
                    rightmax=height[r];
                }
                else{
                    res+=rightmax-height[r];
                }
                r--;
            }
        }
        return res;
    }
}