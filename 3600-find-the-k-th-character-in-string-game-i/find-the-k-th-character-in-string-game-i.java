class Solution {
    public char kthCharacter(int k) {
        StringBuilder start = new StringBuilder("a");
        while (start.length() < k) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < start.length(); i++) {
                temp.append((char) ((start.charAt(i) - 'a' + 1) % 26 + 'a'));
            }
            start.append(temp);
        }
        return start.charAt(k - 1); 
    }
}
