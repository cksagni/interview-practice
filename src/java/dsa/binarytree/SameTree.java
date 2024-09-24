package dsa.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTreeR(TreeNode p, TreeNode q){

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeR(p.left, q.left) && isSameTreeR(p.right, q.right);
    }

    public boolean notSame(TreeNode p, TreeNode q){
        if (p == null && q == null) return false;
        if (p == null || q == null) return true;
        return p.val != q.val;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if (notSame(p, q)) return false;

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
         while (!pQueue.isEmpty()){
             p = pQueue.poll();
             q = qQueue.poll();
             if (notSame(p, q)) return false;
             if (p != null && q != null){
                 pQueue.add(p.left);
                 qQueue.add(q.left);
                 pQueue.add(p.right);
                 qQueue.add(q.right);
             }

         }
        return qQueue.isEmpty();
    }



    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(3);
        TreeNode head2 = new TreeNode(3);
        head1.left = new TreeNode(9);
        head1.right = new TreeNode(20);
        head1.right.left = new TreeNode(15);
        head1.right.right = new TreeNode(7);

        System.out.println(new SameTree().isSameTreeR(head1, head1));
        System.out.println(new SameTree().isSameTree(head1, head1));
        System.out.println();
        System.out.println(new SameTree().isSameTreeR(head1, head2));
        System.out.println(new SameTree().isSameTree(head1, head2));
    }


}
