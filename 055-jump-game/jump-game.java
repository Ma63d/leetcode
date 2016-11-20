# -*- coding:utf-8 -*-


# Given an array of non-negative integers, you are initially positioned at the first index of the array.
#
#
# Each element in the array represents your maximum jump length at that position. 
#
#
# Determine if you are able to reach the last index.
#
#
#
# For example:
# A = [2,3,1,1,4], return true.
#
#
# A = [3,2,1,0,4], return false.


public class Solution {
    public boolean canJump(int[] nums) {
        int lastStop = -1,maxStep = 0;
        while(maxStep < nums.length-1){
            if(maxStep == lastStop) return false;
            int start = lastStop+1;
            lastStop = maxStep;
            for(int i = start;i <= lastStop;i++){
                if(i + nums[i] > maxStep){
                    maxStep = i + nums[i];
                }
            }
        }
        return true;
    }
}
