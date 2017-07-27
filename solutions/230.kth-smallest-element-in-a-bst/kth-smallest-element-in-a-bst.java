/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int cur = 0;
        TreeNode pointer = root;
        while(pointer != null || st.size() != 0){
            if(pointer != null){
                st.push(pointer);
                pointer = pointer.left;
            }else{
                pointer = st.pop();
                cur++;
                if(cur == k){
                    return pointer.val;
                }
                pointer = pointer.right;
            }
        }
        return pointer.val;
    }
}