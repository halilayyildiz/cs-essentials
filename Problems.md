# Topics


### []()

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>



## Arrays And Strings

### [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

<details><summary>Solution</summary><p>
    
```java
public int lengthOfLongestSubstring(String s) {
    if(s == null || s.isEmpty()) return 0;

    Set<Character> set = new HashSet<>();

    int max = 1;
    set.add(s.charAt(0));
    int start=0;
    for(int i=1; i < s.length(); i++){
        if(set.contains(s.charAt(i))){
            while(s.charAt(start) != s.charAt(i)){
                set.remove(s.charAt(start));
                start++;
            }
            start++;
        }else{
            set.add(s.charAt(i));
        }
        max = Math.max(max, i-start+1);
    }
    return max;
}
```

</p></details>

### [10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)

<details><summary>Solution</summary><p>

```java
public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) return text.isEmpty();
    boolean first_match = (!text.isEmpty() &&
                            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        return (isMatch(text, pattern.substring(2)) ||
                (first_match && isMatch(text.substring(1), pattern)));
    } else {
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}
```

</p></details>

### [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) :fire:

- Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
- Your algorithm should run in O(n) complexity.

<details><summary>Solution</summary><p>

```java
public int longestConsecutive(int[] nums) {
   if (nums.length < 2) return nums.length;

    int max = 0;
    Set<Integer> set = new HashSet<>();
    Arrays.stream(nums).forEach(num -> set.add(num));

    for (int i = 0; i < nums.length; i++){
        if (!set.contains(nums[i] - 1)){
            int next = nums[i] + 1;
            int curLen = 1;
            while (set.contains(next)){
                curLen++;
                next++;
            }
            max = Math.max(curLen, max);
        }
    }
    return max;
}
```

</p></details>

### [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

```java

```

### [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

```java

```

### [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

- O(n) time and O(1) space.

<details><summary>Solution</summary><p>

```java
public int firstMissingPositive(int[] nums) {

    for(int i=0; i < nums.length; i++)
        if(nums[i] < 0)
            nums[i] = 0;

    for(int i=0; i < nums.length; i++){
        int n = Math.abs(nums[i]) - 1;

        if(n >= 0 && n < nums.length && nums[n] >= 0)
            nums[n] = nums[n] == 0 ? -1 * nums.length : -1 * nums[n];
    }

    for(int i=0; i < nums.length; i++)
        if(nums[i] >= 0)
            return i+1;

    return nums.length+1;
}
```

</p></details>

### [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

<details><summary>Solution</summary><p>

```java

// TODO

```

</p></details>

### [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

<details><summary>Solution</summary><p>

```java
public int longestOnes(int[] A, int K) {

    int max = 0;

    for(int lo=0, hi=0; hi < A.length; hi++){
        if(A[hi] == 0 && K > 0){
            K--;
        }else if(A[hi] == 0 && K == 0){
            while(K == 0 && lo < A.length){
                if(A[lo] == 0){
                    K++;
                }
                lo++;
            }
            K--;
        }

        max = Math.max(max, hi+1 - lo);
    }

    return max;
}
```

</p></details>

### [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

<details><summary>Solution</summary><p>

```java
public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int res = 0;

        int max = 0;
        for(int lo=0, hi=0; hi < s.length(); hi++){
            max = Math.max(max, ++count[s.charAt(hi) - 'A']);
            if(hi - lo + 1 - max > k){
                count[s.charAt(lo) - 'A']--;
                lo++;
            }
            res = Math.max(res, hi - lo + 1);
        }

        return res;
    }
```

</p></details>


## Linked Lists

## Tree & Graphs

### [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

- In DFS, if you find p and q at the same time, move this parent node up, otherwise move p or q up.

<details><summary>Solution</summary><p>

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

</p></details>


### [173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)

- Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST. 
- Calling next() will return the next smallest number in the BST.

<details><summary>Solution</summary><p>

```java
class BSTIterator {

    private Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode last = s.pop();

        TreeNode node = last.right;
        while(node != null){
            s.push(node);
            node = node.left;
        }

        return last.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
```

</p></details>

### [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [426. Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/) 

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

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

### [341. Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/)

```java
public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack = new Stack<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
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

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [46. Permutations](https://leetcode.com/problems/permutations/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [47. Permutations II](https://leetcode.com/problems/permutations-ii/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [39. Combination Sum](https://leetcode.com/problems/combination-sum/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

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

- ```Search in Rotated Sorted Array``` + allows duplicates 

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

### [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

```java
public List<Interval> merge(List<Interval> intervals) {
    if(intervals.isEmpty()) return new ArrayList<Interval>();

    Stack<Interval> s = new Stack();
    Collections.sort(intervals, (a,b) -> (a.start == b.start) ? a.end - b.end : a.start - b.start);

    Iterator<Interval> it = intervals.iterator();
    s.push(it.next());
    while(it.hasNext()){
        Interval curr = it.next();
        Interval last = s.peek();

        if(last.end >= curr.start){
            s.pop();
            s.push(new Interval(last.start, Math.max(curr.end, last.end)));
        }else{
            s.push(curr);
        }
    }
    return new ArrayList<Interval>(s);
}
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

### [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) :fire:

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

### [91. Decode Ways](https://leetcode.com/problems/decode-ways/)

```java
public int numDecodings(String s) {
    if(s.isEmpty()) return 0;
    
    int n = s.length();
    int[] dp = new int[n+1];
    dp[n] = 1;

    for(int i=n-1;i>=0;i--) {
        if(s.charAt(i) == '0') 
            dp[i] = 0;
        else {
            dp[i] = dp[i+1];
            if(i < (n-1) && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) 
                dp[i]+=dp[i+2];
        }
    }

    return dp[0];   
}
```

## Design

### [146. LRU Cache](https://leetcode.com/problems/lru-cache/)

- Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>

### [211. Add and Search Word - Data Structure Design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)

- Design a data structure that supports the following two operations: `void addWord(word)` and `bool search(word)`

<details><summary>Solution</summary><p>

```java
class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        word = word + "#";

        TrieNode node = root;
        for(int i=0; i < word.length(); i++){
            node = node.children.computeIfAbsent(word.charAt(i), t -> new TrieNode());
        }  
    }

    public boolean search(String word) {
        return searchNode(word + "#", root);
    }

    private boolean searchNode(String word, TrieNode node) {
        if(word.isEmpty()) return true;

        for(int i=0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                // search for every children, one true result is enough
                for(TrieNode child : node.children.values()){
                    if(searchNode(word.substring(i+1,word.length()), child))
                        return true;
                }
                // if not found in any children, then return false
                return false;
            }else{
                node = node.children.get(word.charAt(i));
                if(node == null)
                    return false;
            }
        }

        return true;
    }
}
```

</p></details>

## Others

### [277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) :fire:

- Tricky, ```bool knows(a, b)``` result of this method eliminates either a or b from celebrity candidate

<details><summary>Solution</summary><p>

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

</p></details>

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>
```java
class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
        } 
    }
    
    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        word = word + "#";
        
        TrieNode node = root;
        for(int i=0; i < word.length(); i++){
            node = node.children.computeIfAbsent(word.charAt(i), t -> new TrieNode());
        }  
    }
    
    public boolean search(String word) {
        return searchNode(word + "#", root);
    }

    private boolean searchNode(String word, TrieNode node) {
        if(word.isEmpty()) return true;
        
        for(int i=0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                // search for every children, one true result is enough
                for(TrieNode child : node.children.values()){
                    if(searchNode(word.substring(i+1,word.length()), child))
                        return true;
                }
                // if not found in any children, then return false
                return false;
            }else{
                node = node.children.get(word.charAt(i));
                if(node == null)
                    return false;
            }
        }
        
        return true;
    }
}
```

## Others

### [277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) :fire:

- Tricky, ```bool knows(a, b)``` result of this method eliminates either a or b from celebrity candidate

<details><summary>Solution</summary><p>

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

</p></details>

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>
```java
class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
        } 
    }
    
    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        word = word + "#";
        
        TrieNode node = root;
        for(int i=0; i < word.length(); i++){
            node = node.children.computeIfAbsent(word.charAt(i), t -> new TrieNode());
        }  
    }
    
    public boolean search(String word) {
        return searchNode(word + "#", root);
    }

    private boolean searchNode(String word, TrieNode node) {
        if(word.isEmpty()) return true;
        
        for(int i=0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                // search for every children, one true result is enough
                for(TrieNode child : node.children.values()){
                    if(searchNode(word.substring(i+1,word.length()), child))
                        return true;
                }
                // if not found in any children, then return false
                return false;
            }else{
                node = node.children.get(word.charAt(i));
                if(node == null)
                    return false;
            }
        }
        
        return true;
    }
}
```

## Others

### [277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) :fire:

- Tricky, ```bool knows(a, b)``` result of this method eliminates either a or b from celebrity candidate

<details><summary>Solution</summary><p>

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

</p></details>

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>
```java
class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
        } 
    }
    
    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        word = word + "#";
        
        TrieNode node = root;
        for(int i=0; i < word.length(); i++){
            node = node.children.computeIfAbsent(word.charAt(i), t -> new TrieNode());
        }  
    }
    
    public boolean search(String word) {
        return searchNode(word + "#", root);
    }

    private boolean searchNode(String word, TrieNode node) {
        if(word.isEmpty()) return true;
        
        for(int i=0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                // search for every children, one true result is enough
                for(TrieNode child : node.children.values()){
                    if(searchNode(word.substring(i+1,word.length()), child))
                        return true;
                }
                // if not found in any children, then return false
                return false;
            }else{
                node = node.children.get(word.charAt(i));
                if(node == null)
                    return false;
            }
        }
        
        return true;
    }
}
```

## Others

### [277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) :fire:

- Tricky, ```bool knows(a, b)``` result of this method eliminates either a or b from celebrity candidate

<details><summary>Solution</summary><p>

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

</p></details>

### [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

<details><summary>Solution</summary><p>

```java
// TODO
```

</p></details>
