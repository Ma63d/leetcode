# -*- coding:utf-8 -*-


# Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
#
#
#     For example, given array S = {-1 2 1 -4}, and target = 1.
#
#     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        int distance = Math.abs(target - closest);
        for(int i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int numsI = nums[i];
            int front = i+1;
            int end = nums.length -1;
            while(front < end){
                if(end < nums.length -1 && nums[end] == nums[end+1]){
                    end--;
                    continue;
                }
                if(front>i+1 && nums[front] == nums[front-1]){
                    front++;
                    continue;
                }
                int cur = nums[front] + nums[end] + numsI;
                if(cur == target){
                    return target;
                }else if(cur > target){
                    end--;
                }else{
                    front++;
                }
                int distanceCur = Math.abs(target-cur);
                if(distanceCur < distance){
                    closest = cur;
                    distance = distanceCur;
                }
            }
        }
        return closest;
    }
}
