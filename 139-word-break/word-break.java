# -*- coding:utf-8 -*-


# Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
#
#
# For example, given
# s = "leetcode",
# dict = ["leet", "code"].
#
#
#
# Return true because "leetcode" can be segmented as "leet code".


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return _solve(s,0,new HashSet<>(),wordDict);
    }
    public boolean _solve(String s,int start,Set<Integer> fail,Set<String> wordDict){
        if(start == s.length()) return true;
        for(int i = start+1; i <= s.length();i++){
            if(!fail.contains(i)){
                if(wordDict.contains(s.substring(start,i))){
                    if(_solve(s,i,fail,wordDict)){
                        return true;
                    }
                }
            }
        }   
        fail.add(start);
        return false;
    }
}
