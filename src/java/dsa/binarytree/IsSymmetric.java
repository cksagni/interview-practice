package dsa.dividenconquer.java.dsa.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public boolean isSymmetricR(TreeNode root){
        if (root == null) return true;
        return mirror(root.left, root.right);
    }
    public boolean mirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(3);
        head1.left = new TreeNode(9);
        head1.right = new TreeNode(9);
        head1.left.left = new TreeNode(15);
        head1.right.right = new TreeNode(15);
        System.out.println(new IsSymmetric().isSymmetricR(head1));
        System.out.println(new IsSymmetric().isSymmetric(head1));
    }
}
