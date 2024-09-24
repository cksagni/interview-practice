package dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    List<Integer> output = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            output.add(root.val);
            inorderTraversal(root.right);
        }
        return output;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }
        return output;
    }


    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(3);
        head1.right = new TreeNode(5);
        System.out.println(new InOrderTraversal().inorderTraversal(head1));
        System.out.println(new InOrderTraversal().inorderTraversalIter(head1));
        System.out.println();

    }
}
