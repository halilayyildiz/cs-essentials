package com.halilayyildiz.impl.tree;

import java.util.*;

public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTree();

        System.out.print("Iterative: ");
        PostorderTraversal.iterative(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));

        System.out.println("");

        System.out.print("Recursive: ");
        PostorderTraversal.recursive(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));
    }

    public static List<TreeNode> recursive(TreeNode node) {
        if (node == null)
            return Collections.emptyList();

        List<TreeNode> res = new ArrayList<>();
        res.addAll(recursive(node.right));
        res.addAll(recursive(node.left));
        res.add(node);

        return res;
    }

    public static List<TreeNode> iterative(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();

        // TODO
        
        return res;
    }
}