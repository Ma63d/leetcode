# -*- coding:utf-8 -*-


# Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
#
#
# The same repeated number may be chosen from C unlimited number of times.
#
#
# Note:
#
# All numbers (including target) will be positive integers.
# The solution set must not contain duplicate combinations.
#
#
#
#
# For example, given candidate set [2, 3, 6, 7] and target 7, 
# A solution set is: 
#
# [
#   [7],
#   [2, 2, 3]
# ]


public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target,new ArrayList<Integer>());
        return this.result;
    }
    public void dfs(int[] candidates,int start,int target,List<Integer> lastResult){
        if(target == 0){
            List<Integer> curResult = new ArrayList<Integer>(lastResult);
            this.result.add(curResult);
        }else{
            for(int i = start; i < candidates.length;i++){
                if(target >= candidates[i]){
                    lastResult.add(candidates[i]);
                    dfs(candidates,i,target - candidates[i],lastResult);
                    lastResult.remove(lastResult.size()-1);
                }else{
                    break;
                }
            }
        }
    }
}
