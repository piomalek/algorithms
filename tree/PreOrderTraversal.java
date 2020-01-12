import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {

    public static List<Integer> iterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            result.add(n.getVal());

            if(n.getRight() != null) stack.push(n.getRight());
            if(n.getLeft() != null) stack.push(n.getLeft());
        }

        return result;
    }

    public static List<Integer> recursive(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        recursive(root, result);

        return  result;
    }

    private static void recursive(TreeNode root, List<Integer> result) {
        if(root == null) return;

        result.add(root.getVal());
        recursive(root.getLeft(), result);
        recursive(root.getRight(), result);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();

        System.out.println("Pre-Order traversal:");
        System.out.println("recursive: " + recursive(root));
        System.out.println("iterative: " + iterative(root));
    }
}
