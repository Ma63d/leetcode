# -*- coding:utf-8 -*-


# Given a sorted array of integers, find the starting and ending position of a given target value.
#
# Your algorithm's runtime complexity must be in the order of O(log n).
#
# If the target is not found in the array, return [-1, -1].
#
#
# For example,
# Given [5, 7, 7, 8, 8, 10] and target value 8,
# return [3, 4].


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ret;
        }
        if(nums.length == 1){
            if(nums[0] == target){
                ret[0] = ret[1] = 0;
            }
            return ret;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = (left +  right)/2;
            if(nums[middle] == target){
                if(middle > 0 && nums[middle-1] == target){
                    ret[0] = searchRangeWithRightTarget(nums,left,middle -1,target);
                }else{
                    ret[0] = middle;
                }
                if(middle < nums.length-1 && nums[middle+1] == target){
                    ret[1] = searchRangeWithLeftTarget(nums,middle + 1,right,target);
                }else{
                    ret[1] = middle;
                }
                return ret;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return ret;
    }
    public int searchRangeWithRightTarget(int[] nums,int start,int end,int target){
        int result = end;
        while(start < end){
            int middle = (start + end)/2;
            if(nums[middle] < target){
                start = middle + 1;
            }else if(nums[middle] == target){
                result = middle;
                end = middle;
            }
        }
        return result;
    }
    public int searchRangeWithLeftTarget(int[] nums,int start,int end,int target){
        int result = start;
        while(start < end){
            int middle = (start + end + 1)/2;
            if(nums[middle] > target){
                end = middle -1;
            }else if(nums[middle] == target){
                result = middle;
                start = middle;
            }
        }
        return result;
    }
}
