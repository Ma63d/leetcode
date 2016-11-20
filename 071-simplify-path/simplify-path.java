# -*- coding:utf-8 -*-


# Given an absolute path for a file (Unix-style), simplify it.
#
# For example,
# path = "/home/", => "/home"
# path = "/a/./b/../../c/", => "/c"
#
#
# click to show corner cases.
#
# Corner Cases:
#
#
#
# Did you consider the case where path = "/../"?
# In this case, you should return "/".
# Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
# In this case, you should ignore redundant slashes and return "/home/foo".


public class Solution {
    public String simplifyPath(String path) {
        Stack<String> result = new Stack<String>();
        String[] str = path.split("/");
        for(int i = 0;i < str.length;i++){
            switch(str[i]){
                case "":break;
                case ".":break;
                case "..":if(!result.empty()){
                    result.pop();
                }
                break;
                default: result.push(str[i]);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(result.empty()){
            return "/";
        }
        while(!result.empty()){
            sb.insert(0,"/"+result.pop());
        }
        return sb.toString();
    }
}
