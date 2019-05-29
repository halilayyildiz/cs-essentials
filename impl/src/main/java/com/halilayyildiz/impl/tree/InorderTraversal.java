package com.halilayyildiz.impl.tree;

import java.util.*;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTree();

        System.out.print("Iterative 1 >> ");
        InorderTraversal.iterative1(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));

        System.out.println("");

        System.out.print("Iterative 2 >> ");
        InorderTraversal.iterative2(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));

        System.out.println("");

        System.out.print("Iterative 3 >> ");
        InorderTraversal.iterative3(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));

        System.out.println("");

        System.out.print("Recursive   >> ");
        InorderTraversal.recursive(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));
    }

    public static List<TreeNode> recursive(TreeNode node) {
        if (node == null)
            return Collections.emptyList();

        List<TreeNode> res = new ArrayList<>();
        res.addAll(recursive(node.left));
        res.add(node);
        res.addAll(recursive(node.right));

        return res;
    }

    public static List<TreeNode> iterative1(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();

        if (node == null)
            return res;

        Stack<TreeNode> s = new Stack<>();
        while (true) {

            while (node != null) {
                s.push(node);
                node = node.left;
            }

            if (s.isEmpty())
                break;

            node = s.pop();
            res.add(node);
            node = node.right;
        }
        return res;
    }

    public static List<TreeNode> iterative2(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();

        if (node == null)
            return res;

        Stack<TreeNode> s = new Stack<>();
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;

            } else {
                node = s.pop();
                res.add(node);
                node = node.right;
            }
        }

        return res;
    }

    public static List<TreeNode> iterative3(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();

        if (node == null) return res;

        Stack<TreeNode> s = new Stack<>();
        pushAllLeft(node, s);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur);
            pushAllLeft(cur.right, s);
        }
        return res;
    }

    private static void pushAllLeft(TreeNode node, Stack<TreeNode> s) {
        while (node != null) {
            s.add(node);
            node = node.left;
        }
    }
}