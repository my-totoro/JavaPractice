package hk.edu.cuhk.bigdata.practice;

import hk.edu.cuhk.bigdata.practice.PracticeCommon.TreeNode;
/**
 * 面试题55：二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点一次经过的节点（含根、叶节点）形成树的
 * 一条路径，最长路径的长度为树的深度。
 *
 * 思路：递归方法，树的深度是根的左右节点深度最大的加1
 *
 * 变种：平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差
 * 不超过1，那么它就是一棵平衡二叉树。
 */

public class DepthOfBinaryTree {

    private int treeDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

    //效率低，每个节点可能被遍历很多次
    private boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int diff = leftDepth - rightDepth;
        if(diff > 1 || diff < -1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }

    //高效解法，先遍历左右子树，然后再遍历根节点，这样就不会重复遍历左右子节点中的节点
    private boolean efficientIsBalanced(TreeNode root) {
        return efficientIsBalancedHelper(root).isBalanced;

    }

    class BoundedResult{
        boolean isBalanced;
        int depth;
        BoundedResult(boolean b, int d){
            isBalanced = b;
            depth = d;
        }
    }
    //后序遍历，遍历到根节点已经知道左右字数的平衡情况
    private BoundedResult efficientIsBalancedHelper(TreeNode root){
        if(root == null) {
            return new BoundedResult(true, 0);
        }
        BoundedResult left = efficientIsBalancedHelper(root.left);
        BoundedResult right = efficientIsBalancedHelper(root.right);
        if(left.isBalanced && right.isBalanced) {
            int leftDepth = left.depth;
            int rightDepth = right.depth;
            int diff = leftDepth - rightDepth;
            if(diff <= 1 && diff >= -1) {
                int depth = (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
                return new BoundedResult(true, depth);
            }
        }

        return new BoundedResult(false, -1);
    }
}
