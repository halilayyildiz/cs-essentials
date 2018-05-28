package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LowestCommonAncestorOfABinaryTree
{

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
        {
            return null;
        }

        if (root.val == p.val || root.val == q.val)
        {
            return root;
        }

        TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
        TreeNode right_lca = lowestCommonAncestor(root.right, p, q);

        if (left_lca != null && right_lca != null)
        {
            return root;
        }

        if (left_lca != null)
        {
            return left_lca;
        }
        else
        {
            return right_lca;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode commonAncestor = null;

        // check corner cases
        if (root == null || p == null || q == null)
        {
            return null;
        }
        // find paths to nodes from root
        List<TreeNode> pathtoP = findPathToNode(root, p, new ArrayList<>());
        List<TreeNode> pathtoQ = findPathToNode(root, q, new ArrayList<>());

        System.out.println(pathtoP.stream().map(treeNode -> treeNode.val + "").collect(Collectors.joining(",")));
        System.out.println(pathtoQ.stream().map(treeNode -> treeNode.val + "").collect(Collectors.joining(",")));

        // find common ancestor
        for (int i = 0; i < Math.min(pathtoP.size(), pathtoQ.size()); i++)
        {
            if (pathtoP.get(i).val == pathtoQ.get(i).val)
            {
                commonAncestor = pathtoP.get(i);
            }
            else
            {
                break;
            }
        }

        return commonAncestor;
    }

    private List<TreeNode> findPathToNode(TreeNode root, TreeNode p, List<TreeNode> path)
    {
        path.add(root);
        if (root.val == p.val)
        {
            return path;
        }
        else
        {
            if (root.left != null)
            {
                List<TreeNode> pathToNode = findPathToNode(root.left, p, new ArrayList<>(path));
                if (pathToNode != null)
                {
                    return pathToNode;
                }
            }
            if (root.right != null)
            {
                List<TreeNode> pathToNode = findPathToNode(root.right, p, new ArrayList<>(path));
                if (pathToNode != null)
                {
                    return pathToNode;
                }
            }

            return null;
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, new TreeNode(7), new TreeNode(4)).val);

    }
}
