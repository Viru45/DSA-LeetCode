/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        return getBST(nums, 0, nums.length - 1);
    }

    public TreeNode getBST(int[] nums, int startIndx, int endIndx){
        if(startIndx > endIndx) return null;


        int middleIndx = (startIndx + endIndx)/2;
        TreeNode bst = new TreeNode(nums[middleIndx]);
        bst.left = getBST(nums, startIndx, middleIndx - 1);
        bst.right = getBST(nums, middleIndx + 1, endIndx);

        return bst;
    }
}