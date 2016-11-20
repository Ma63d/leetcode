# -*- coding:utf-8 -*-


# Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
#
#
# Note:
# You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j =0;
        for(;i > -1;i--){
            nums1[i+n] = nums1[i];
        }
        i = n;
        int l =0;
        while(i < m+n && j < n){
            if(nums1[i] < nums2[j]){
                nums1[l++] = nums1[i++];
            }else{
                 nums1[l++] = nums2[j++];
            }
        }
        while(i < m+n){
            nums1[l++] = nums1[i++];
        }
        while(j < n){
            nums1[l++] = nums2[j++];
        }
    }
}
