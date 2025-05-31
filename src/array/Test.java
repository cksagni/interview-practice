package array;

import binarytree.InOrderTraversal;
import binarytree.TreeNode;

import java.util.StringJoiner;

public class Test {


    public static String serialize(TreeNode root) {
        StringJoiner res = new StringJoiner(" ");
        serializeDFS(root, res);
        return res.toString();
    }

    private static void serializeDFS(TreeNode root, StringJoiner result) {
        if (root == null) {
            result.add("x");
            return;
        }
        result.add(Integer.toString(root.val));
        serializeDFS(root.left, result);
        serializeDFS(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2, new TreeNode(3), null);
        head1.right = new TreeNode(6);
        System.out.println(Test.serialize(head1));

    }

}
