# -*- coding:utf-8 -*-


# Given an unsorted integer array, find the first missing positive integer.
#
#
#
# For example,
# Given [1,2,0] return 3,
# and [3,4,-1,1] return 2.
#
#
#
# Your algorithm should run in O(n) time and uses constant space.


public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        int i;
        for(i = 0;i < nums.length;i++){
            if(nums[i] != i+1){
                break;
            }
        }
        return i+1;
    }
}
