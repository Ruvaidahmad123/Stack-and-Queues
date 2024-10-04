class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        // Frequency array to count occurrences of each skill value
        int[] freq = new int[1001];
        int totalSum = 0;

        for (int s : skill) {
            totalSum += s;
            freq[s]++; // Update frequency
        }

        int teams = n / 2;

        // Check if total sum is divisible by the number of teams
        if (totalSum % teams != 0) {
            return -1;
        }

        int targetSum = totalSum / teams;
        long chemistry = 0;

        for (int currSkill : skill) {
            int remainingSkill = targetSum - currSkill;

            // If the complementary skill is not available, return -1
            if (freq[remainingSkill] <= 0) {
                return -1;
            }

            chemistry += (long) currSkill * (long) remainingSkill;
            freq[remainingSkill]--; // Reduce the frequency of used skill
        }

        return chemistry / 2;
    }
}