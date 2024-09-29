public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> nums) {
        int n=nums.size();
        ArrayList<Integer>nge= new ArrayList<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while (!st.isEmpty() && st.peek() >= nums.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge.add(-1);
            } else {
                nge.add(st.peek());
            }
            st.push(nums.get(i));
        }
        return nge;
    }
}
