O(2n) space
class Solution {
    public int trap(int[] height) {
        int res=0;
        int n=height.length;
        int lmax[]=new int[n];
        int rmax[]=new int[n];
        lmax[0]=height[0];
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
        }
        rmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],height[i]);
        }
        for(int i=1;i<n-1;i++){
            res=res+(Math.min(lmax[i],rmax[i])-height[i]);
        }
        return res;
    }
}


O(1) space
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
