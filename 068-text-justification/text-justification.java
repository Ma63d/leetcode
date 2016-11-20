# -*- coding:utf-8 -*-


# Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
#
#
#
# You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
#
#
#
# Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
#
#
#
# For the last line of text, it should be left justified and no extra space is inserted between words.
#
#
#
# For example,
# words: ["This", "is", "an", "example", "of", "text", "justification."]
# L: 16.
#
#
#
# Return the formatted lines as:
#
# [
#    "This    is    an",
#    "example  of text",
#    "justification.  "
# ]
#
#
#
#
# Note: Each word is guaranteed not to exceed L in length.
#
#
#
# click to show corner cases.
#
# Corner Cases:
#
#
# A line other than the last line might contain only one word. What should you do in this case?
# In this case, that line should be left-justified.


public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int start = 0,alreadyLen = words[0].length();
        for(int i = 0;i < words.length;i++){
            if(i+1 < words.length){
                if(alreadyLen+words[i+1].length() + 1 > maxWidth){
                    result.add(justify(words,start,i,alreadyLen,maxWidth));
                    start = i+1;
                    alreadyLen = words[i+1].length();
                }else{
                    alreadyLen += words[i+1].length() + 1;
                }
            }else{
                result.add(justify(words,start,i,alreadyLen,maxWidth));
            }
        }
        return result;
    }
    public String justify(String[] words, int start,int i ,int alreadyLen,int maxWidth){
        if(start == i){
            while(alreadyLen < maxWidth){
                    words[start] += ' ';
                    alreadyLen++;
            }
            return words[start];
        }else{
            StringBuilder sb = new StringBuilder();
            if(i == words.length-1){
                sb.append(words[start]);
                while(start+1 <= i){
                    sb.append(' ');
                    sb.append(words[++start]);
                }
                while(alreadyLen < maxWidth){
                    sb.append(' ');
                    alreadyLen++;
                }
            }else{
                int len = i - start;
                int pad = (maxWidth-alreadyLen)/len;
                int left = (maxWidth-alreadyLen) - pad*len;
                sb.append(words[start]);
                while(start+1 <= i){
                    StringBuilder append = new StringBuilder();
                    for(int j = 0;j < pad;j++){
                        append.append(' ');
                    }
                    sb.append(append);
                    if(left > 0){
                        sb.append(' ');
                        left--;
                    }
                    sb.append(' ');
                    sb.append(words[++start]);
                }
            }
            return sb.toString();
        }
    }
}
