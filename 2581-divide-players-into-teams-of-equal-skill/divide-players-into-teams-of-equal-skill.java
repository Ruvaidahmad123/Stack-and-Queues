class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int low=0;
        int high=skill.length-1;
        long sum=0;
        long check=skill[low]+skill[high];
        while(low<high){
            if(skill[low]+skill[high]!=check){
                return -1;
            }
            else{
                sum+=skill[low]*skill[high];
            }
            low++;
            high--;
        }
        return sum;
    }
}