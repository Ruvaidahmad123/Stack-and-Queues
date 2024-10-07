//Approach-1 (Brute Force)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replaceFirst("AB", "");
            } else if (s.contains("CD")) {
                s = s.replaceFirst("CD", "");
            }
        }
        return s.length();
    }
}

//Approach-2 (Using stack)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (st.isEmpty()) {
                st.push(currentChar);
                continue;
            }

            if (currentChar == 'B' && st.peek() == 'A') {
                st.pop();
            } else if (currentChar == 'D' && st.peek() == 'C') {
                st.pop();
            } else {
                st.push(currentChar);
            }
        }

        return st.size();
    }
}

//Approach-3 (Using 2 pointers = i : read, j ; write)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minLength(String s) {
        int n = s.length();
        
        StringBuilder sb = new StringBuilder(s);
        int i = 0; // Write pointer
        int j = 1; // Read pointer

        while (j < n) {
            if (i < 0) {
                i++;
                sb.setCharAt(i, sb.charAt(j));
            } else if ((sb.charAt(i) == 'A' && sb.charAt(j) == 'B') ||(sb.charAt(i) == 'C' && sb.charAt(j) == 'D')) {
                i--;
            } else {
                i++;
                sb.setCharAt(i, sb.charAt(j));
            }
            j++;
        }
        return i + 1;
    }
}
