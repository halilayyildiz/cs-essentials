# Topics

## Arrays And Strings

### [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

**TODO**

## Linked Lists

## Tree & Graphs

### [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

- In DFS, if you find p and q at the same time, move this parent node up, otherwise move p or q up.

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
{
    if (root == null) return null;

    if (root == p || root == q){
        return root;
    }

    TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
    TreeNode right_lca = lowestCommonAncestor(root.right, p, q);

    if (left_lca != null && right_lca != null){
        return root;
    }
    if (left_lca != null){
        return left_lca;
    }
    else{
        return right_lca;
    }   
}
```

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

```java
public List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    backtrack(s, new ArrayList<String>(), list);
    return list;
}

private void backtrack(String s, List<String> temp, List<List<String>> list){
    if(s.isEmpty()){
        list.add(new ArrayList<String>(temp));
    }
    
    for(int i=0; i < s.length(); i++){
        String str = s.substring(0,i+1);
        String revStr = new StringBuilder(str).reverse().toString();
        if(str.equals(revStr)){
            temp.add(str);
            backtrack(s.substring(i+1), temp, list);
            temp.remove(temp.size()-1);
        }
    }
}
```







## Sorting and Searching

### [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

- When you find middle, one of the sides will be sorted already, check if target values is in that sorted range, otherwise continue with other side.

```java
public int search(int[] nums, int target) {

    int start=0;
    int end=nums.length-1;
    
    while(start <= end){
        int mid = (start+end)/2;
        
        if(nums[mid] == target){
            return mid;
        }
        
        if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1; 
                }
        } 
        if (nums[mid] <= nums[end]){
            if (target > nums[mid] && target <= nums[end]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    }
    
    return -1;
}
```

### [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
-  ```Search in Rotated Sorted Array``` + allows duplicates 

```java
public boolean search(int[] nums, int target) {

    int start=0;
    int end=nums.length-1;

    while(start <= end){
        int mid = (start+end)/2;

        if(nums[mid] == target){
            return true;
        }
        
        if (nums[mid] == nums[start]) {
            start++;
        }else if (nums[start] <= nums[mid]){
            if (target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
            }else{
                start = mid + 1; 
            }
        } 
        else if (nums[mid] <= nums[end]){
            if (target > nums[mid] && target <= nums[end]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    }

    return false;
```


## Dynamic Programming

### [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- Kadene's Algorithm

```java
public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int subArrayMax = 0;

    for (int i = 0; i < nums.length; i++){
        subArrayMax += nums[i];
        max = Math.max(max, subArrayMax);
        subArrayMax = Math.max(subArrayMax, 0);
    }

    return max;
}
```

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

### [277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) :fire:

- Tricky, ```bool knows(a, b)``` result of this method eliminates either a or b from celebrity candidate

```java
public int findCelebrity(int n) {
    int candidate = 0;

    // find celebrity candidate
    for(int i = 1; i < n; i++){
        if(knows(candidate, i)) candidate = i;
    }
    // test candidate -> celebrity or not
    for(int i = 0; i < n; i++){
        if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
    }
    return candidate;
}
```

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

**TODO**