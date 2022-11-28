package cn.sepiggy.tree.leetcode.p144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // 用来进行递归的栈
        Stack<TreeNode> s = new Stack<>();
        // 用来存放遍历的结果，不算在空间复杂度里面
        List<Integer> ans = new ArrayList<>();
        // 开始利用栈来进行遍历
        while (root != null || !s.empty()) {
            // 模拟递归的压栈过程
            while (root != null) {
                s.push(root);
                ans.add(root.val);
                root = root.left;
            }
            // 当无法压栈的时候，将root.right进行压栈
            root = s.peek();
            s.pop();
            root = root.right;
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}