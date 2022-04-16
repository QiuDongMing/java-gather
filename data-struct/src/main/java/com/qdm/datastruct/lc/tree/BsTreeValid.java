package com.qdm.datastruct.lc.tree;

import org.junit.Test;

public class BsTreeValid  {
    static long pre = Long.MIN_VALUE;

    /**
     *                  5
     *             3        7
     *          1     4   6    8
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(4);
        TreeNode l1 = new TreeNode(3, l2, l3);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(8);
        TreeNode r1 = new TreeNode(7, r2, r3);
        TreeNode treeData = new TreeNode(5, l1, r1);
        isValidBST(treeData);

    }

/**
 *                  5
 *             3        7
 *          1     4   6    8
 */
        public static boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 访问左子树
            if (!isValidBST(root.getLeft())) {
                return false;
            }
            System.out.println("root.getVal() = " + root.getVal());
            // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
            if (root.getVal() <= pre) {
                return false;
            }
            pre = root.getVal();
            // 访问右子树
            return isValidBST(root.getRight());
        }


    //letcode answer
    private static boolean isValidTree(TreeNode treeNode, Integer lower, Integer upper) {
        if(treeNode == null) return true;
        if (treeNode.getVal() <= lower || treeNode.getVal() >= upper) {
            return false;
        }
        return isValidTree(treeNode, lower, treeNode.getVal()) && isValidTree(treeNode, treeNode.getVal(), upper);
    }

    @Test
    public void valid() {
        TreeNode treeNode = new TreeNode(0);
        treeNode.setLeft(new TreeNode(Integer.MIN_VALUE));
        treeNode.setRight(new TreeNode(Integer.MAX_VALUE));
        System.out.println("isValidTree() = " + isValidTree(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }





}
