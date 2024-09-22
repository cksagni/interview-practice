package binarytree;

public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder){

        return null;

    }

    public static void main(String[] args) {
        int[] inorder = new int[]{};
        int[] postorder = new int[]{};
        TreeNode root = new ConstructBinaryTree().buildTree(inorder, postorder);
        System.out.println(new LevelOrderTraversal().levelOrder(root));

    }
}
