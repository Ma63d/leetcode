public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result  = new int[findNums.length];
        if(findNums.length < 1) return result;
        for(int i = 0;i < findNums.length;i++){
            map.put(findNums[i],i);
            result[i] = -1;
        }
        int i = 0;
        while(i < nums.length){
            if(st.size() == 0 || st.peek() > nums[i]){
                st.push(nums[i]);
                i++;
            }else{
                int lastTop = st.pop();
                if(map.get(lastTop) != null){
                    int pos = map.get(lastTop);
                    result[pos] = nums[i];
                }
            }
        }
        return result;
    }
}