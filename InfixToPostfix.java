class Solution {
    // Function to convert an infix expression to a postfix expression.
    static int Prec(char ch) {
    switch (ch) {
    case '+':
    case '-':
      return 1;

    case '*':
    case '/':
      return 2;

    case '^':
      return 3;
    }
    return -1;
  }
    public static String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character>st=new Stack<>();
        int i=0;
        int n=exp.length();
        while(i<n){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result+=ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    result+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && Prec(ch)<=Prec(st.peek())){
                    result+=st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}
