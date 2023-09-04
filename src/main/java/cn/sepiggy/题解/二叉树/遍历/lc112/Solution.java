package cn.sepiggy.题解.二叉树.遍历.lc112;

/**
 * lc112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 * https://appktavsiei5995.pc.xiaoe-tech.com/p/t_pc/course_pc_detail/video/v_63ac4a26e4b0fc5d121d71b5?product_id=p_63a8545ee4b02685a42d4c48&content_app_id=&type=8&parent_pro_id=p_63a81b2ce4b030cacaff539c
 */
class Solution {

    int currentPathSum = 0;
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        traverse(root, targetSum);
        return res;
    }

    private void traverse(TreeNode root, int targetSum) {

        // base case
        if (root == null) {
            return;
        }

        // 前序遍历位置
        currentPathSum += root.val;

        // 叶子节点
        if (root.left == null && root.right == null) {
            if (currentPathSum == targetSum) {
                res = true;
                return;
            }
        }
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);

        // 后序遍历位置
        currentPathSum -= root.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
