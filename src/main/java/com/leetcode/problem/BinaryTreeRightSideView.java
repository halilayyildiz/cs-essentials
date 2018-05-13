package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView
{
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null)
        {
            return new ArrayList<Integer>();
        }
        
        List<TreeNode> visitList = new ArrayList<>();
        visitList.add(root);
        while(!visitList.isEmpty())
        {
            List<TreeNode> newVisitList = new ArrayList<>();
            for (int i = 0; i < visitList.size(); i++)
            {
                TreeNode node = visitList.get(i);
                if(node.right != null)
                {
                    newVisitList.add(node.right);
                }
                if(node.left != null)
                {
                    newVisitList.add(node.left);
                }
                if(i == 0)
                {
                    resultList.add(node.val);
                }
            }
            visitList = newVisitList;
        }
        
        return resultList;
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        
        new BinaryTreeRightSideView().rightSideView(root );
    }
}
