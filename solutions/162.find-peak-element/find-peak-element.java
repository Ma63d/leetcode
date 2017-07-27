public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length < 2) return 0;
        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            int middle = (left + right) / 2;
            if(nums[middle] > nums[middle-1] && nums[middle] > nums[middle +1]){
                return middle;
            } else if(nums[middle] > nums[middle-1]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return nums[right] > nums[left] ? right : left;
    }
}