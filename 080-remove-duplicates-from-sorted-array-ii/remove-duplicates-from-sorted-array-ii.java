# -*- coding:utf-8 -*-


# Follow up for "Remove Duplicates":
# What if duplicates are allowed at most twice?
#
#
# For example,
# Given sorted array nums = [1,1,1,2,2,3],
#
#
# Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int current = nums[0];
        int currentCount = 1;
        int totalCount = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] ==current){
                if(++currentCount < 3){
                    totalCount++;
                    if(totalCount!=i){
                        nums[totalCount] = nums[i];
                    }
                }
            }else{
                totalCount++;
                current = nums[i];
                currentCount = 1;
                if(totalCount!=i){
                    nums[totalCount] = nums[i];
                }
            }
        }
        return totalCount+1;
    }
}
