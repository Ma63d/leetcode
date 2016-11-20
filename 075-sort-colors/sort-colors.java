# -*- coding:utf-8 -*-


# Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
#
#
#
# Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
#
#
#
# Note:
# You are not suppose to use the library's sort function for this problem.
#
#
# click to show follow up.
#
#
# Follow up:
# A rather straight forward solution is a two-pass algorithm using counting sort.
# First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
# Could you come up with an one-pass algorithm using only constant space?


public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 2){
            return;
        }
        int left = 0,right = nums.length-1;
        while(left<right){
            while(nums[left] < 2 && left < right){
                left++;
            }
            while(nums[right] == 2 && left < right){
                right--;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left]= temp;
        }
        if(left != 0){
            if(nums[left] == 2){
                right = left - 1;
            }else{
                right = left;
            }
            left = 0;
            while(left<right){
                while(nums[left] == 0 && left < right){
                    left++;
                }
                while(nums[right] == 1 && left < right){
                    right--;
                }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left]= temp;
            }
        }
    }
}
