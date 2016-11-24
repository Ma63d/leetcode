# -*- coding:utf-8 -*-


# Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
#
#
# For example,
# Given [100, 4, 200, 1, 3, 2],
# The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
#
#
# Your algorithm should run in O(n) complexity.


public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i < nums.length;i++){
            set.add(nums[i]);
        }
        int maxLen = 1;
        
        while(!set.isEmpty()){
            Iterator<Integer> it = set.iterator();
            int cur = it.next();
            int len = 1;
            HashSet<Integer> visited = new HashSet<Integer>();
            visited.add(cur);
            int start = cur-1,end = cur+1;
            while(true){
                if(!set.contains(start) && !set.contains(end)){
                    break;
                }else{
                    if(set.contains(start)){
                        visited.add(start);
                        start--;
                        len++;
                    }
                    if(set.contains(end)){
                        visited.add(end);
                        end++;
                        len++;
                    }
                }
            }
            if(len > maxLen){
                maxLen = len;
            }
            for(Integer i : visited){
                set.remove(i);
            }
        }
        return maxLen;
    }
}
