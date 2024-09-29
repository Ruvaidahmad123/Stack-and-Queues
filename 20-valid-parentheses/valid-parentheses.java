class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('|| s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty()){
                    if(s.charAt(i)==')' && st.peek().equals('(')){
                        st.pop();
                    }
                    else if(s.charAt(i)=='}' && st.peek().equals('{')){
                        st.pop();
                    }
                    else if(s.charAt(i)==']' && st.peek().equals('[')){
                        st.pop();
                    }
                    else{
                        st.push(s.charAt(i));
                    }
                }
                else{
                    st.push(s.charAt(i));
                }
            }  
        }
        return st.size()==0;
    }
}