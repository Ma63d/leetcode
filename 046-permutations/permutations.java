# -*- coding:utf-8 -*-


# Given a collection of distinct numbers, return all possible permutations.
#
#
#
# For example,
# [1,2,3] have the following permutations:
#
# [
#   [1,2,3],
#   [1,3,2],
#   [2,1,3],
#   [2,3,1],
#   [3,1,2],
#   [3,2,1]
# ]


public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<List<Integer>>();
        ArrayList<Integer> numsToUse = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            numsToUse.add(nums[i]);
        }
        ArrayList<Integer> alreadyAdd = new ArrayList<Integer>();
        addNums(alreadyAdd,numsToUse);
        return this.result;
    }
    public void addNums(List<Integer> alreadyAdd,List<Integer> left){
        if(left.isEmpty()){
            List<Integer> newResult = new ArrayList<Integer>(alreadyAdd);
            this.result.add(newResult);
        }else{
            for(int i = 0;i < left.size();i++){
                int k = (int)left.remove(i);
                alreadyAdd.add(k);
                addNums(alreadyAdd,left);
                alreadyAdd.remove(alreadyAdd.size()-1);
                left.add(i,k);
            }
        }
    }
}
