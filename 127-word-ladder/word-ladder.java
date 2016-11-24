# -*- coding:utf-8 -*-


# Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
#
#
# Only one letter can be changed at a time
# Each intermediate word must exist in the word list
#
#
#
# For example,
#
#
# Given:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
#
#
# As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
# return its length 5.
#
#
#
# Note:
#
# Return 0 if there is no such transformation sequence.
# All words have the same length.
# All words contain only lowercase alphabetic characters.


public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)){
            return 1;
        }
        wordList.add(endWord);
        wordList.remove(beginWord);
        HashSet<String> already = new HashSet<String>();
        already.add(beginWord);
        int result = 1;
        while(wordList.contains(endWord)){
            result++;
            if(already.isEmpty()) return 0;
            HashSet<String> newAlready = new HashSet<String>();
            for(String cur : already){
                StringBuilder curr = new StringBuilder(cur);
                if(difference(cur,endWord) == 1) return result;
                for(int i = 0;i < cur.length();i++){
                    char c = curr.charAt(i);
                    for(int j = 0; j < 26;j++){
                        curr.setCharAt(i,(char)('a'+j)); 
                        if(wordList.contains(curr.toString())){
                            wordList.remove(curr.toString());
                            newAlready.add(curr.toString());
                        }
                    }
                    curr.setCharAt(i,c);
                }
            }
            already = newAlready;
        }
        return result;    
    }
    public int difference(String s, String t) {
        int result = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) != t.charAt(i)){
                if(++result > 1){
                    return result;
                }
            }
        }
        return result;
    }
}
