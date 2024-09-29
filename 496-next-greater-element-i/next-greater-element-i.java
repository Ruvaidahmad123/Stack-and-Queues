class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>st=new Stack<>();
        int n=nums2.length;
        int nextge[]=new int[n];
        nextge[n-1]=-1;
        st.push(nums2[n-1]);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextge[i]=-1;
            }
            else{
                nextge[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums2[i],i);
        }
        int result[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int indexInNextGe=map.get(nums1[i]);
            result[i]=nextge[indexInNextGe];
        }
        return result;
    }
}