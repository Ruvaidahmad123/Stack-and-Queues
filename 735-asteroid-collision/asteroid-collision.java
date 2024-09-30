class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]<0){
                int posval=Math.abs(asteroids[i]);
                while(!st.isEmpty() && st.peek()<posval && st.peek()>0){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
                if(st.peek()==posval){
                    st.pop();
                }
            }
            else{
                st.push(asteroids[i]);
            }
        }
        int res[]=new int[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()) {
            res[i--] = st.pop();
        }
        return res;
    }
}