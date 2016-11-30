# -*- coding:utf-8 -*-


# Evaluate the value of an arithmetic expression in Reverse Polish Notation.
#
#
#
# Valid operators are +, -, *, /. Each operand may be an integer or another expression.
#
#
#
# Some examples:
#
#   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
#   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int right = st.pop();
                int left = st.pop();
                int result = 0;
                if(token.equals("+")){
                    result = left + right;
                }else if(token.equals("-")){
                    result = left - right;
                }else if(token.equals("*")){
                    result = left * right;
                }else if(token.equals("/")){
                    result = left / right;
                }
                st.push(result);
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
