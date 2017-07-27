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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode runner = root;
        while(runner != null || !st.empty()){
            if(runner != null){
                result.add(runner.val);
                if(runner.right != null) st.push(runner.right);
                runner = runner.left;
            }else if(!st.empty()){
                runner = st.pop();
            }
        }
        return result;
    }
}