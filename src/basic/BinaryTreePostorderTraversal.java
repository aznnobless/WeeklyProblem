package basic;
import java.util.*;

public class BinaryTreePostorderTraversal {

    public List<Integer> postOrderIteratively(TreeNode root)
    {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.isEmpty() || current != null)
        {
            if(current != null)
            {
                stack.push(current);
                result.addFirst(current.val);
                current = current.right;
            }
            else
            {
                TreeNode node = stack.pop();
                current = node.left;
            }
        }

        return result;
    }

    public List<Integer> postorderIterativelyUsingTwoStack(TreeNode root)
    {
        List<Integer> toReturn = new ArrayList<>();
        if (root == null) return toReturn;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        TreeNode current;
        while (!s1.isEmpty())
        {
            current = s1.pop();
            s2.push(current);
            if (current.left != null) s1.push(current.left);
            if (current.right != null) s1.push(current.right);
        }

        while (!s2.isEmpty())
        {
            current = s2.pop();
            toReturn.add(current.val);
        }

        return toReturn;
    }

    public List<Integer> postOrderTraversalRecursively(TreeNode root)
    {
        List<Integer> toReturn = new ArrayList<>();
        postOrderTraversalRecursively(root, toReturn);
        return toReturn;
    }

    public static void postOrderTraversalRecursively(TreeNode root, List<Integer> toReturn)
    {
        if (root == null) return;
        postOrderTraversalRecursively(root.left, toReturn);
        postOrderTraversalRecursively(root.right, toReturn);
        toReturn.add(root.val);
    }

    public static void print(List<Integer> list)
    {
        for(int num : list)
        {
            System.out.print(num +  " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        BinaryTreePostorderTraversal p = new BinaryTreePostorderTraversal();
        print(p.postOrderIteratively(TreeNode.getBasicSampleTree()));
        print(p.postorderIterativelyUsingTwoStack(TreeNode.getBasicSampleTree()));
        print(p.postOrderTraversalRecursively(TreeNode.getBasicSampleTree()));
    }
}
