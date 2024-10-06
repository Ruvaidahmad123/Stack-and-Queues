class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0;  // pointer for the beginning (prefix)
        int j = 0;  // pointer for the end (suffix)

        // Ensure words1 is the longer sentence, if not swap them
        if (words1.length < words2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        // Find the longest matching prefix
        while (i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        // Find the longest matching suffix
        while (j < words2.length && words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        // Check if all the words from the shorter sentence (words2) are covered
        // by either the prefix or suffix
        return i + j >= words2.length;
    }
}
