# -*- coding:utf-8 -*-


# The set [1,2,3,&#8230;,n] contains a total of n! unique permutations.
#
# By listing and labeling all of the permutations in order,
# We get the following sequence (ie, for n = 3):
#
# "123"
# "132"
# "213"
# "231"
# "312"
# "321"
#
#
#
# Given n and k, return the kth permutation sequence.
#
# Note: Given n will be between 1 and 9 inclusive.


public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < n;i++){
            result.append(i+1);
        }
        reOrder(result,k);
        return result.toString();
    }
    public void reOrder(StringBuilder result,int k){
        if(k == 1) return;
        int multiResult = 1;
        int multiTimes = 1;
        while(multiResult*(multiTimes+1) < k){
            multiTimes++;
            multiResult *= multiTimes;
        }
        int change = (k-1)/multiResult;
        result.insert(result.length()-multiTimes-1,result.charAt(result.length()-multiTimes-1+change));
        result.deleteCharAt(result.length()-multiTimes-1+change);
        reOrder(result,k-change*multiResult);
    }
}
