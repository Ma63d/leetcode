public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap();
        for(int i = 0;i < nums.length;i++){
            if(m.get(nums[i]) != null) {
                result[0] = m.get(nums[i]);
                result[1] = i;
                return result;
            }else {
                m.put(target-nums[i],i);
            }
        }
        return result;
    }
}