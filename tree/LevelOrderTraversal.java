import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelByLevelTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                TreeNode n = queue.remove();
                level.add(n.getVal());

                if(n.getLeft() != null) queue.offer(n.getLeft());
                if(n.getRight() != null) queue.offer(n.getRight());
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();

        List<List<Integer>> levelList = levelByLevelTraversal(root);

        for(int lvl = 0; lvl < levelList.size(); ++lvl) {
            System.out.println(String.format("level %d: %s", lvl + 1, levelList.get(lvl)));
        }
    }
}
