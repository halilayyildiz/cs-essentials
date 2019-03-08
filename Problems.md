# Topics

## Arrays And Strings

## Linked Lists

## Tree & Graphs

### [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

```java
public void flatten(TreeNode root) {
    flat(root);
}
private TreeNode flat(TreeNode node){
    if(node == null){
        return null;
    }

    TreeNode left = node.left;
    TreeNode right = node.right;

    TreeNode last = node;
    if(left != null){
        node.right = left;
        last = flat(left);
    }
    if(right != null){
        last.right = right;
        last = flat(right);
    }

    node.left = null;
    return last;
}
```



## Backtracking

## Sorting and Searching

## Dynamic Programming

## Others
