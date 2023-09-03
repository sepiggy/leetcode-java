package cn.sepiggy.题解.二叉树.遍历.lc101;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * lc101.对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 */
class Solution {

    private List<Integer> leftList = new LinkedList<>();
    private List<Integer> rightList = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        traverseLeftPre(root.left);
        traverseLeftPre(root.right);

        Integer[] leftListArray = leftList.toArray(new Integer[leftList.size()]);
        Integer[] rightListArray = rightList.toArray(new Integer[rightList.size()]);

        return Arrays.equals(leftListArray, rightListArray);
    }

    private void traverseLeftPre(TreeNode root) {

        if (root == null) {
            return;
        }

        leftList.add(root.val);
        traverseLeftPre(root.left);
        traverseLeftPre(root.right);
    }

    private void traverseRightPre(TreeNode root) {

        if (root == null) {
            return;
        }

        rightList.add(root.val);
        traverseRightPre(root.right);
        traverseRightPre(root.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}