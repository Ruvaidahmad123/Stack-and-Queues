public class Solution  {
    public int findCelebrity(int mat[][]) {
        int n=mat.length;
        int[] iknow = new int[n];   // Tracks how many people each person knows
        int[] knowme = new int[n];  // Tracks how many people know each person
        
        // Traverse the 2D matrix and fill the iknow and knowme arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && mat[i][j]==1) {
                    iknow[i]++;       // i knows j
                    knowme[j]++;      // j is known by i
                }
            }
        }
        
        // Check for the celebrity
        for (int i = 0; i < n; i++) {
            if (iknow[i] == 0 && knowme[i] == n - 1) {
                return i;  // i is the celebrity
            }
        }
        
        return -1;  // No celebrity found
    }
}


public int findCelebrity(int[][] mat) {
        int n = mat.length;
        int top = 0;
        int down = n - 1;
        
        // Narrow down the candidate using two pointers
        while (top < down) {
            if (mat[top][down] == 1) {
                // top knows down, so top cannot be the celebrity
                top++;
            } 
            else {
                // top does not know down, so down cannot be the celebrity
                top++;
                down--;
            }
        }
        int candidate=top;
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should not know anyone, and everyone should know the candidate
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;  // No celebrity found
                }
            }
        }
        return candidate;
}
