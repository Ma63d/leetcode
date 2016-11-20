# -*- coding:utf-8 -*-


# Given an array of strings, group anagrams together.
#
#
# For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
# Return:
#
# [
#   ["ate", "eat","tea"],
#   ["nat","tan"],
#   ["bat"]
# ]
#
# Note: All inputs will be in lower-case.


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i = 0; i < strs.length;i++){
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            String reRankStr = new String(cur);
            ArrayList<String> curResult = map.get(reRankStr);
            if(curResult == null){
                curResult = new ArrayList<String>();
                curResult.add(strs[i]);
                map.put(reRankStr,curResult);
            }else{
                curResult.add(strs[i]);    
            }
        }
        ArrayList<List<String>> ret = new ArrayList<List<String>>();
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            ArrayList<String> strList = (ArrayList<String>)entry.getValue();
            Collections.sort(strList);
            ret.add(strList);
        }
        return ret;
    }
}
