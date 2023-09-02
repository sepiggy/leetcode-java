package cn.sepiggy.模板.tree.p1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    List<Integer> dfs(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            result.add(treeNode.val);

            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }

        return result;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Main main = new Main();
        List<Integer> result = main.dfs(root);
        String str = result.stream().map(it -> String.valueOf(it)).collect(Collectors.joining(",", "[", "]"));
        System.out.println(str);
    }
}
