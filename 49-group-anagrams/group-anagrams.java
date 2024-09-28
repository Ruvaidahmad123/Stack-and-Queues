class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(String s:strs){
            char newarr[]=s.toCharArray();
            Arrays.sort(newarr);
            String newstr=new String(newarr);
            if(!ans.containsKey(newstr)){
                ans.put(newstr,new ArrayList<>());
            }
            ans.get(newstr).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}