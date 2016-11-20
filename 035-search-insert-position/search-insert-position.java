# -*- coding:utf-8 -*-


# Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
#
# You may assume no duplicates in the array.
#
#
# Here are few examples.
# [1,3,5,6], 5 &#8594; 2
# [1,3,5,6], 2 &#8594; 1
# [1,3,5,6], 7 &#8594; 4
# [1,3,5,6], 0 &#8594; 0


public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        while(left <= right){
            int middle = (left + right)/2;
            if(nums[middle] == target){
                left = middle;
                break;
            } else if(nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }
}
