import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {

    public static List<Integer> iterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while(p != null || !stack.isEmpty()) {
            while(p != null) {
                stack.push(p);
                p = p.getLeft();
            }

            p = stack.pop();

            result.add(p.getVal());

            p = p.getRight();
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
        result.add(root.getVal());
        recursive(root.getRight(), result);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();

        System.out.println("In-Order traversal:");
        System.out.println("recursive: " + recursive(root));
        System.out.println("iterative: " + iterative(root));    }
}
