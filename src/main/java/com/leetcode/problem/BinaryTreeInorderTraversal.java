package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<TreeNode> traversalList = new ArrayList<>();
        Set<TreeNode> nodesAlreadyProcessed = new HashSet<>();

        if (root == null)
        {
            return new ArrayList<>();
        }

        traversalList.add(root);
        while (traversalList.size() != nodesAlreadyProcessed.size())
        {
            List<TreeNode> newTraversalList = new ArrayList<>();

            for (TreeNode node : traversalList)
            {
                if (!nodesAlreadyProcessed.contains(node))
                {
                    if (node.left != null)
                    {
                        newTraversalList.add(node.left);
                    }
                    newTraversalList.add(node);
                    nodesAlreadyProcessed.add(node);
                    if (node.right != null)
                    {
                        newTraversalList.add(node.right);
                    }
                }
                else
                {
                    newTraversalList.add(node);
                }
            }

            traversalList = newTraversalList;
        }

        return traversalList.stream().map(node -> node.val)
                .collect(Collectors.toList());
    }
}
