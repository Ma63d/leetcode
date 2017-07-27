public class Solution {
    public class Node {
        int left;
        int right;
        Node(int l, int r){
            left = l;
            right = r;
        }
    }
    public int longestConsecutive(int[] nums) {
        // if(nums.length < 2) return nums.length;
        // HashSet<Integer> set = new HashSet<Integer>();
        // for(int i = 0;i < nums.length;i++){
        //     set.add(nums[i]);
        // }
        // int maxLen = 1;
        
        // while(!set.isEmpty()){
        //     Iterator<Integer> it = set.iterator();
        //     int cur = it.next();
        //     int len = 1;
        //     HashSet<Integer> visited = new HashSet<Integer>();
        //     visited.add(cur);
        //     int start = cur-1,end = cur+1;
        //     while(true){
        //         if(!set.contains(start) && !set.contains(end)){
        //             break;
        //         }else{
        //             if(set.contains(start)){
        //                 visited.add(start);
        //                 start--;
        //                 len++;
        //             }
        //             if(set.contains(end)){
        //                 visited.add(end);
        //                 end++;
        //                 len++;
        //             }
        //         }
        //     }
        //     if(len > maxLen){
        //         maxLen = len;
        //     }
        //     for(Integer i : visited){
        //         set.remove(i);
        //     }
        // }
        // return maxLen;
        
        
        //二刷
        if(nums.length < 2) return nums.length;
        int maxLen = 1;
        HashMap<Integer,Node> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == null){
                int left = nums[i],
                    right = nums[i];
                Node leftNode = null;
                if(map.get(nums[i]-1) != null){
                    left = map.get(nums[i]-1).left;
                    leftNode = map.get(left);
                    leftNode.right = nums[i];
                }
                if(map.get(nums[i]+1) != null){
                    right = map.get(nums[i]+1).right;
                    Node rightNode = map.get(right);
                    rightNode.left = left;
                    if(leftNode != null){
                        leftNode.right = right;
                    }
                }
                Node currentNode = new Node(left,right);
                if(right-left +1 > maxLen ) maxLen = right-left +1;
                System.out.println(left+" "+right);
                map.put(nums[i],currentNode);
            }
        }
        return maxLen;
    }
}