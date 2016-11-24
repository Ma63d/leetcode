# -*- coding:utf-8 -*-


# Given numRows, generate the first numRows of Pascal's triangle.
#
#
# For example, given numRows = 5,
# Return
#
# [
#      [1],
#     [1,1],
#    [1,2,1],
#   [1,3,3,1],
#  [1,4,6,4,1]
# ]


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 1;i <= numRows;i++){
            ArrayList<Integer> currentResult = new ArrayList<Integer>();
            for(int j = 1;j <= i;j++){
                if(j == 1){
                    currentResult.add(1);
                }else if(j == i){
                    currentResult.add(1);
                }else{
                    currentResult.add(result.get(i-2).get(j-2)+result.get(i-2).get(j-1));
                }
            }
            result.add(currentResult);
        }
        return result;
    }
}
