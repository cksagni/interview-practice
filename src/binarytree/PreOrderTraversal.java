package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    List<Integer> output = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            output.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return output;

    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(3);
        head1.right = new TreeNode(5);
        System.out.println(new PreOrderTraversal().preorderTraversal(head1));

    }
}
