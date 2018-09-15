package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal
{
    // Recursively

    public List<Integer> preorderTraversalRecursively(TreeNode root, List<Integer> toReturn)
    {
        if (root == null) return toReturn;

        toReturn.add(root.val);

        if (root.left != null)
            preorderTraversalRecursively(root.left, toReturn);

        if (root.right != null)
            preorderTraversalRecursively(root.right, toReturn);

        return toReturn;

    }

    // Iteratively : Using stack and add right child first

    public  List<Integer> preorderTraversalIteratively(TreeNode root)
    {
        List<Integer> toReturn = new ArrayList<>();

        if (root == null) return toReturn;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty())
        {
            TreeNode node = s.pop();
            toReturn.add(node.val);

            if (root.right != null) s.push(node.right);
            if (root.left != null) s.push(node.left);
        }

        return toReturn;
    }





}
