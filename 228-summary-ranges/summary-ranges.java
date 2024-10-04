class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>list=new ArrayList<>();
        int startidx=0;
        int n=nums.length;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]!=1 && i==startidx){
                list.add(nums[startidx]+"");
                startidx=i+1;
            }
            else if(nums[i+1]-nums[i]!=1 && i!=startidx){
                list.add(nums[startidx]+"->"+nums[i]);
                startidx=i+1;
            }
        }
        if(startidx<n-1)
        list.add(nums[startidx]+"->"+nums[n-1]);
        else if(startidx==n-1){
            list.add(nums[n-1]+"");
        }
        return list;
    }
}