package binarytree;

import java.util.*;

public class LevelOrderTraversal {

    List<List<Integer>> output = new ArrayList<>();



    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            temp = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            output.add(temp);
        }
        return output;
    }



    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(3);
        head1.left = new TreeNode(9);
        head1.right = new TreeNode(20);
        head1.right.left = new TreeNode(15);
        head1.right.right = new TreeNode(7);
        System.out.println(new LevelOrderTraversal().levelOrder(head1));
    }
}
