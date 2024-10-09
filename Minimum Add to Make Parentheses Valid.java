o(n) space
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()=='(' && s.charAt(i)==')'){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.size();
    }
}

O(1) space
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<String> st=new Stack<>();
        int openCount=0;
        int closeCount=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                openCount++;
            }
           else
            {
                if(openCount>0)
                {
                    openCount--;
                }
                else
                closeCount++;
            }
        }
        return openCount+closeCount;
    }
}
