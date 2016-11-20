# -*- coding:utf-8 -*-


# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
#
#
# For example,
# If n = 4 and k = 2, a solution is:
#
#
#
# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ]


public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<List<Integer>>();
        _solve(n,0,k,new ArrayList<Integer>());
        return this.result;
    }
    public void _solve(int n,int alreadyUse,int left,ArrayList<Integer> res){
        for(int i = alreadyUse+1;i <= n-left+1;i++){
            res.add(i);
            if(left == 1){
                this.result.add(new ArrayList(res));
            }else{
                _solve(n,i,left-1,res);
            }
            res.remove(res.size()-1);
        }
    }
}
