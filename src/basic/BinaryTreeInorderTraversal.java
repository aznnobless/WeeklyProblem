package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {


    // Recursively

    public List<Integer> inorderTraversalRecursively(TreeNode root, List<Integer> toReturn)
    {
        if (root == null) return toReturn;

        if (root.left != null)
            inorderTraversalRecursively(root.left, toReturn);

        toReturn.add(root.val);

        if (root.right != null)
            inorderTraversalRecursively(root.right, toReturn);

        return toReturn;
    }

    // Iteratively
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> toReturn = new ArrayList<>();

        if (root == null) return toReturn;

        Stack<TreeNode> s = new Stack<>();

        TreeNode current = root;

        while(current != null || s.size() > 0) {

            while (current != null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            toReturn.add(current.val);
            current = current.right;
        }

        return toReturn;
    }

    public static void main(String[] args)
    {
        BinaryTreeInorderTraversal p = new BinaryTreeInorderTraversal();
        List<Integer> result = p.inorderTraversal(TreeNode.getBasicSampleTree());
        for(int num : result)
        {
            System.out.print(num + " ");
        }

    }
}
