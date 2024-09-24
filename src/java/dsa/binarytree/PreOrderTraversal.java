package dsa.dividenconquer.java.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    List<Integer> output = new ArrayList<>();

    public List<Integer> preorderTraversalR(TreeNode root) {
        if (root != null) {
            output.add(root.val);
            preorderTraversalR(root.left);
            preorderTraversalR(root.right);
        }
        return output;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return output;
    }



    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(3);
        head1.right = new TreeNode(5);
        System.out.println(new PreOrderTraversal().preorderTraversalR(head1));
        System.out.println(new PreOrderTraversal().preorderTraversal(head1));

    }
}
