package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    List<Integer> output = new ArrayList<>();

    public List<Integer> postorderTraversalR(TreeNode root) {
        if (root != null) {
            postorderTraversalR(root.left);
            postorderTraversalR(root.right);
            output.add(root.val);
        }
        return output;
    }

    public List<Integer> postorderTraversalReverse(TreeNode root) {
        if (root == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);

        }
        return output.reversed();
    }

    public List<Integer> postorderTraversal2Stack(TreeNode root) {
        if (root == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> pathStack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            root = stack.peek();
            if (!pathStack.empty() && pathStack.peek()==root){
                output.add(root.val);
                pathStack.pop();
                stack.pop();
            } else {
                pathStack.add(root);

                if (root.right != null) stack.add(root.right);
                if (root.left != null) stack.add(root.left);
            }
        }
        return output;
    }

    public List<Integer> postorderTraversal1Stack(TreeNode root) {
        if (root == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (root.right == null || root.right == prevNode){
                    output.add(root.val);
                    stack.pop();
                    prevNode = root;
                    root = null;
                } else {
                    root = root.right;
                }
            }
        }
        return output;
    }





    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(3);
        head1.right = new TreeNode(5);
        System.out.println(new PostOrderTraversal().postorderTraversalR(head1));
        System.out.println(new PostOrderTraversal().postorderTraversalReverse(head1));
        System.out.println(new PostOrderTraversal().postorderTraversal2Stack(head1));
        System.out.println(new PostOrderTraversal().postorderTraversal1Stack(head1));

    }
}
