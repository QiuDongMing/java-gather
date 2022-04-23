package com.qdm.datastruct.lc.tree;

public class TreeNodeData {


    /**
     *          4
     *      2        6
     *   1    3    5   7
     *
     * 先序： 4 2 1 3 6 5 7
     * 中序： 1 2 3 4 5 6 7
     * 后序： 1 3 2 5 7 6 4
     * @return
     */
    public static TreeNode getInitTreeData() {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        root.setLeft(left);
        TreeNode right = new TreeNode(6);
        root.setRight(right);
        TreeNode t = new TreeNode(1);
        left.setLeft(t);
        left.setRight(new TreeNode(3));
        right.setLeft(new TreeNode(5));
        right.setRight(new TreeNode(7));
        return root;
     }





}
