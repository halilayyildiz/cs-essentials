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

### [78. Subsets](https://leetcode.com/problems/subsets/)

```java
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack(list, nums, new ArrayList<Integer>(), 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> tempList, int start){
        list.add(new ArrayList(tempList));
        for(int i=start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, nums, tempList, i+1);
            tempList.remove(tempList.size()-1);   
        }
    }
```

### [90. Subsets II](https://leetcode.com/problems/subsets-ii/)

```

```

### [46. Permutations](https://leetcode.com/problems/permutations/)

```

```

### [47. Permutations II](https://leetcode.com/problems/permutations-ii/)

```

```

### [39. Combination Sum](https://leetcode.com/problems/combination-sum/)

```

```

### [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

```

```

### [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)

```

```

### [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

```

```







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

### [354. Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)
- Sort the array. Ascend on width and descend on height if width are same.
- Find the longest increasing subsequence based on height

```

```


## Others

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

**TODO**