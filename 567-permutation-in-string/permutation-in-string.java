class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays for s1 and the sliding window in s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Fill the frequency array for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check if the first window is a match
        if (matches(s1Count, s2Count)) {
            return true;
        }

        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Include the next character in the window
            s2Count[s2.charAt(i) - 'a']++;
            // Remove the character that's no longer in the window
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            // Check if the current window matches s1
            if (matches(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to check if two frequency arrays match
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
