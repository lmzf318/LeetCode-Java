package com.yyn.lc.tree;

/**
 * Created by jiy on 5/25/16.
 * 1. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 */
public class BinaryTree {
    /**
     * Definition of TreeNode:
     * public class TreeNode {
     * public int val;
     * public TreeNode left, right;
     * public TreeNode(int val) {
     * this.val = val;
     * this.left = this.right = null;
     * }
     * }
     */
    private class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;

        depth = travel(root, 1, depth);

        return depth;
    }

    private int travel(TreeNode node, int level, int depth) {
        if (node.left == null && node.right == null) {
            depth = Math.max(depth, level);
        }

        if (node.left != null) {
            depth = travel(node.left, level + 1, depth);
        }

        if (node.right != null) {
            depth = travel(node.right, level + 1, depth);
        }

        return depth;
    }
}
