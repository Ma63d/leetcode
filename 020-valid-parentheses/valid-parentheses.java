# -*- coding:utf-8 -*-


# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
# The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }
        Stack chars = new Stack();
        for(int i = 0;i < s.length();i++){
            char charI = s.charAt(i);
            if(charI == '(' || charI == '{' || charI == '[' ){
                chars.push(charI);
            }else if(charI == ')' || charI == '}' || charI == ']' ){
                if(chars.empty()) return false;
                char charInStackTop = (char)chars.pop();
                if(!((charI == ')' && charInStackTop == '(') ||(charI == ']' && charInStackTop == '[') || (charI == '}' && charInStackTop == '{'))){
                    return false;
                }
            }
        }
    
        return chars.empty();
    }
}
