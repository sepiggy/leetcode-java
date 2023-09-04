package cn.sepiggy.题解.二叉树.遍历.lc116;


/**
 * lc116. 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-cbce8/#%E7%AC%AC%E4%BA%8C%E9%A2%98%E3%80%81%E5%A1%AB%E5%85%85%E8%8A%82%E7%82%B9%E7%9A%84%E5%8F%B3%E4%BE%A7%E6%8C%87%E9%92%88
 * 遍历思维模式：
 * 1) 一棵二叉树被抽象成了一棵三叉树，三叉树上的每个节点就是原先二叉树的两个相邻节点
 * 2) 我们只要实现一个 traverse 函数来遍历这棵三叉树，每个「三叉树节点」需要做的事就是把自己内部的两个二叉树节点穿起来
 */
class Solution {
    // 主函数
    public Node connect(Node root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    private void traverse(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return;
        }

        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}