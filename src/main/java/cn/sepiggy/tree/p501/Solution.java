package cn.sepiggy.tree.p501;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int preCnt = 0;
    private int preValue = Integer.MAX_VALUE;
    private int ansCnt = 0;

    private void inOrder(TreeNode root, List<Integer> ans) {

        if (root != null) {
            // 先遍历左子树
            inOrder(root.left, ans);

            // 然后遍历中间的根结点
            if (preValue == root.val) {
                preCnt++;
            } else {
                preValue = root.val;
                preCnt = 1;
            }

            if (ans != null) {
                if (preCnt == ansCnt) {
                    ans.add(preValue);
                }
            }
            ansCnt = Math.max(ansCnt, preCnt);

            // 最后遍历右子树
            inOrder(root.right, ans);
        }

    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        inOrder(root, null);

        preCnt = 0;
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);

        return ans.stream().mapToInt(i -> i).toArray();
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