package com.halilayyildiz.impl.tree;

import java.util.*;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTree();

        System.out.print("Iterative: ");
        PreorderTraversal.iterative(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));

        System.out.println("");

        System.out.print("Recursive: ");
        PreorderTraversal.recursive(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));
    }

    public static List<TreeNode> recursive(TreeNode node) {
        if (node == null)
            return Collections.emptyList();

        List<TreeNode> res = new ArrayList<>();
        res.add(node);
        res.addAll(recursive(node.left));
        res.addAll(recursive(node.right));

        return res;
    }

    public static List<TreeNode> iterative(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();

        if (node == null)
            return res;

        Stack<TreeNode> s = new Stack<>();
        while (true) {

            while (node != null) {
                res.add(node);
                s.push(node);
                node = node.left;
            }

            if (s.isEmpty())
                break;

            node = s.pop();
            node = node.right;
        }
        return res;
    }
}