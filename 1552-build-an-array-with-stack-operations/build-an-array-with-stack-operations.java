class Solution {
    public List<String> buildArray(int[] target, int n) {
        HashSet<Integer>set=new HashSet<>();
        List<String>ans=new ArrayList<>();
        int last=0;
        for(int x:target){
            set.add(x);
            last=x;
        }
        for(int i=1;i<=n;i++){
            if(set.contains(i)){
                ans.add("Push");
                if(i==last){
                    break;
                }
            }
            else{
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}