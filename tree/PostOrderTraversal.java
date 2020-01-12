import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {

    public static List<Integer> iterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode lastVisited = null;
        TreeNode p = root;

        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.getLeft();
            } else {
                TreeNode topStackN = stack.peek();

                // if right child exists and traversing node
                // from left child, then move right
                if(topStackN.getRight() != null && lastVisited != topStackN.getRight()) {
                    p = topStackN.getRight();
                } else {
                    result.add(topStackN.getVal());
                    lastVisited = stack.pop();
                }
            }
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

        recursive(root.getLeft(), result);
        recursive(root.getRight(), result);
        result.add(root.getVal());
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();

        System.out.println("Post-Order traversal:");
        System.out.println("recursive: " + recursive(root));
        System.out.println("iterative: " + iterative(root));
    }
}
