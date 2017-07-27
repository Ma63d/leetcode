/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    if(root == null) return true;
    return searchWithRange(root,-Infinity,Infinity);
};

function searchWithRange(node, start, end){
    if(node.val <= start || node.val >= end) return false;
    if(node.left != null){
        if(!searchWithRange(node.left,start, node.val)) return false;
    }
    if(node.right != null){
        if(!searchWithRange(node.right,node.val,end)) return false;
    }
    return true;
}