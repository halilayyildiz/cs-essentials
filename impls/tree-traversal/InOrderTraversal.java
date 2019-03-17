
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTree();

        System.out.print("Iterative: ");
        InOrderTraversal.iterative(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));

        System.out.println("");

        System.out.print("Recursive: ");
        InOrderTraversal.recursive(root).stream().map(n -> n.val).forEach(val -> System.out.print(val + " "));
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
}