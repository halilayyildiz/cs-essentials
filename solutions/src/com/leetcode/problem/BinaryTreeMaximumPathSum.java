package com.leetcode.problem;

public class BinaryTreeMaximumPathSum
{
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        nodePathSum(root);
        return maxPathSum;
    }

    private int nodePathSum(TreeNode node)
    {
        int leftPathSum = node.left != null ? nodePathSum(node.left) : 0;
        int rightPathSum = node.right != null ? nodePathSum(node.right) : 0;

        int nodePathSum = Math.max(node.val, leftPathSum + node.val);
        nodePathSum = Math.max(nodePathSum, rightPathSum + node.val);

        maxPathSum = Math.max(maxPathSum, leftPathSum + node.val + rightPathSum);
        maxPathSum = Math.max(maxPathSum, nodePathSum);

        return nodePathSum;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);

        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
}
