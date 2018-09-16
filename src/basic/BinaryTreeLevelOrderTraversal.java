package basic;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderOne(TreeNode root)
    {
        List<List<Integer>> toReturn = new ArrayList<>();

        if (root == null) return toReturn;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++)
            {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            toReturn.add(subList);
        }

        return toReturn;
    }

    // faster
    public List<List<Integer>> levelOrderTwo(TreeNode root)
    {
        List<List<Integer>> toReturn = new ArrayList<>();

        if (root == null) return toReturn;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            toReturn.add(list);
        }
        return toReturn;
    }
}
