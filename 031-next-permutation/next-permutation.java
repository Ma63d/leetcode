# -*- coding:utf-8 -*-


# Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
#
#
# If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
#
#
# The replacement must be in-place, do not allocate extra memory.
#
#
# Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
# 1,2,3 &#8594; 1,3,2
# 3,2,1 &#8594; 1,2,3
# 1,1,5 &#8594; 1,5,1


public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        int j;
        for(j = nums.length - 1;j > 0 && nums[j] <= nums[j- 1];j--);
        if(j == 0){
            Arrays.sort(nums,0,nums.length);
            return;
        }else{
            int temp = nums[j-1];
            int i;
            for(i = j;i+1 < nums.length && temp < nums[i+1];i++);
            nums[j-1] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums,j,nums.length);
        }
    }
}
