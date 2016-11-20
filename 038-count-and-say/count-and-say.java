# -*- coding:utf-8 -*-


# The count-and-say sequence is the sequence of integers beginning as follows:
# 1, 11, 21, 1211, 111221, ...
#
#
#
# 1 is read off as "one 1" or 11.
# 11 is read off as "two 1s" or 21.
# 21 is read off as "one 2, then one 1" or 1211.
#
#
#
# Given an integer n, generate the nth sequence.
#
#
#
# Note: The sequence of integers will be represented as a string.


public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1;i < n;i++){
            String temp = "";
            char last = result.charAt(0);int count = 1;
            for(int j = 1;j <= result.length();j++){
                if(j == result.length() ){
                    temp += count;temp += last;
                    continue;
                }
                if(result.charAt(j) !=last){
                    temp += count;temp += last;
                    last = result.charAt(j);
                    count = 1;
                }else{
                    count++;
                }
            }
            result = temp;
        }
        return result;
    }
}
