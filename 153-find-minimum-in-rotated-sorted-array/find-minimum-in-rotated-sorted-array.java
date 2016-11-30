# -*- coding:utf-8 -*-


# Suppose a sorted array is rotated at some pivot unknown to you beforehand.
#
# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
#
# Find the minimum element.
#
# You may assume no duplicate exists in the array.


public class Solution {
    public int findMin(int[] nums) {
        return _find(nums,0,nums.length-1);
    }
    public int _find(int[] nums,int start,int end){
        if(nums[start] < nums[end]){
            return nums[start];
        }
        if(start +1 >= end){ 
            if(start == end)return nums[end];
            else return Math.min(nums[start],nums[end]);
        }
        int middle = (start + end)/2;
        if(nums[middle] > nums[start]){
            return _find(nums,middle+1,end);
        }else{
            return _find(nums,start,middle);
        }
    }
}
