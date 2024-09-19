package binarytree;

public class MaxDepth {

    int answer;

    public int maxDepthTopDown(TreeNode root){
        maxDepth(root, 1);
        return answer;
    }

    public void maxDepth(TreeNode root, int depth){
        if (root==null) return;

        if (root.left == null && root.right == null){
            answer = Math.max(answer, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }

    public int maxDepthBottomUp(TreeNode root){

        if (root == null) return 0;
        return 1 + Math.max(maxDepthBottomUp(root.left), maxDepthBottomUp(root.right));

    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(3);
        head1.left = new TreeNode(9);
        head1.right = new TreeNode(20);
        head1.right.left = new TreeNode(15);
        head1.right.right = new TreeNode(7);
        System.out.println(new MaxDepth().maxDepthTopDown(head1));
        System.out.println(new MaxDepth().maxDepthBottomUp(head1));
    }
}
