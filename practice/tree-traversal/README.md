# Tree Traversal

## Inorder Tree Traversal 

###  Recursive
```java
public static List<TreeNode> recursive(TreeNode node) {
    if (node == null)
        return Collections.emptyList();

    List<TreeNode> res = new ArrayList<>();
    res.addAll(recursive(node.left));
    res.add(node);
    res.addAll(recursive(node.right));

    return res;
}
```
### Iterative
```java
public static List<TreeNode> iterative(TreeNode node) {
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
```

## Preorder Tree Traversal 

###  Recursive

```java
public static List<TreeNode> recursive(TreeNode node) {
    if (node == null)
        return Collections.emptyList();

    List<TreeNode> res = new ArrayList<>();
    res.add(node);
    res.addAll(recursive(node.left));
    res.addAll(recursive(node.right));

    return res;
}
```

###  Iterative

```java
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
```

## Postorder Tree Traversal 

###  Recursive

```java


```

###  Iterative

```java


```
