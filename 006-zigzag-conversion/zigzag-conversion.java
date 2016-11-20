# -*- coding:utf-8 -*-


# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
#
# P   A   H   N
# A P L S I I G
# Y   I   R
#
#
# And then read line by line: "PAHNAPLSIIGYIR"
#
#
# Write the code that will take a string and make this conversion given a number of rows:
#
# string convert(string text, int nRows);
#
# convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


public class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if(chars.length < 2 || numRows == 1){
            return s;
        }
        if(chars.length <= numRows){
            return s;
        }
        int mod = 2 * numRows -2;
        String[] arr = new String[numRows];
        for(int i = 0;i < numRows;i++){
            arr[i] = "";
        }
        for(int j = 0;j < chars.length;j += mod){
            for(int i = 0;i < numRows && j+i < chars.length;i++){
                if(i == 0){
                    arr[i] += chars[j];
                }else if(i == numRows-1){
                    arr[i] += chars[j+i];
                }else{
                    arr[i] += chars[j+i] + ((mod-i+j < chars.length)?chars[mod-i+j]+"":"");
                }
            }
        }
        String result = "";
        for(int i = 0;i < numRows;i++){
            result+=arr[i];
        }
        return result;
    }
}
