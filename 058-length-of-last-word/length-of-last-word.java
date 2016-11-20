# -*- coding:utf-8 -*-


# Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
#
# If the last word does not exist, return 0.
#
# Note: A word is defined as a character sequence consists of non-space characters only.
#
#
# For example, 
# Given s = "Hello World",
# return 5.


public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int max = 0;
        boolean start = false;
        for(int i = s.length() -1;i > -1;i--){
            if(s.charAt(i) != ' '){
                start = true;
                len++;
                if(len > max) max = len;
            }else if(start){
                return max;
            }
        }
        return max;
    }
}
