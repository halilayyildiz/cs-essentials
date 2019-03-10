# Topics

## Arrays And Strings

### [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

**TODO**

## Linked Lists

## Tree & Graphs

### [426. Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/) 

**TODO**

### [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

```java
public void flatten(TreeNode root) {
    flat(root);
}
private TreeNode flat(TreeNode node){
    if(node == null) return null;

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

### [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

```java
public int lengthOfLIS(int[] nums) {
    if (nums.length < 2) return nums.length;
    
    int longestLen = 1;
    int[] dp = new int[nums.length];
    
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++){
        int maxLen = 0;
        for (int j = 0; j < i; j++){
            if (nums[j] < nums[i]){
                maxLen = Math.max(maxLen, dp[j]);
            }
        }
        dp[i] = maxLen + 1;
        longestLen = Math.max(longestLen, dp[i]);
    }
    return longestLen;
}
```

## Others

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

**TODO**