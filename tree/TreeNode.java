import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    //coma separated list ordered root, left, right, left.left, left.right, right.left, right.right, left.left.left ...
    public static TreeNode buildTree(String treeStr){
        List<TreeNode> nodes = Arrays.stream(treeStr.split(",")).map(s -> "null".equals(s) ? null : new TreeNode(Integer.valueOf(s))).collect(Collectors.toList());

        int idx = 0;
        Queue<TreeNode> stack = new LinkedList<>();
        TreeNode root = nodes.get(idx++);
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.remove();
            TreeNode left = idx < nodes.size() ? nodes.get(idx++) : null;
            TreeNode right = idx < nodes.size() ? nodes.get(idx++) : null;
            curr.setLeft(left);
            curr.setRight(right);

            if(left != null) stack.offer(left);
            if(right != null) stack.offer(right);
        }

        return root;
    }

    public static TreeNode getDefaultTree() {
        return buildTree("4,2,6,1,3,5,7");
        //return buildTree("1,2,null,3,null");
    }
}
