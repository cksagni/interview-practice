package dsa.dividenconquer.java.dsa.binarytree;

import java.util.Stack;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null) return false;

        targetSum -= root.val;

        if (root.left == null & root.right == null) return (targetSum == 0);
        return (hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum));
    }

    public boolean hasPathSumIter(TreeNode root, int targetSum){
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.add(root);
        sumStack.add(targetSum - (root != null ? root.val : 0));
        while (!nodeStack.isEmpty()){
            TreeNode currNode = nodeStack.pop();
            int sum = sumStack.pop();
            if (currNode.left == null && currNode.right == null && sum == 0) return true;
            if (sum < 0) continue;
            if (currNode.left != null){
                nodeStack.add(currNode.left);
                sumStack.add(sum - currNode.left.val);
            }
            if (currNode.right != null){
                nodeStack.add(currNode.right);
                sumStack.add(sum - currNode.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(3);
        head1.left = new TreeNode(9);
        head1.right = new TreeNode(20);
        head1.right.left = new TreeNode(15);
        head1.right.right = new TreeNode(7);
        System.out.println(new PathSum().hasPathSum(head1, 12));
        System.out.println(new PathSum().hasPathSumIter(head1, 12));
        System.out.println(new PathSum().hasPathSumIter(head1, 22));
    }
}
