package com.qdm.datastruct.lc.tree;

public class TreeNodeData {


    /**
     *          1
     *      2        3
     *   4    5    6   7
     *
     * 先序： 1 2 4 5 3 6 7
     * 中序： 4 2 5 1 6 3 7
     * 后序： 4 5 2 6 7 3 1
     * @return
     */
    public static TreeNode getInitTreeData() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.setLeft(left);
        TreeNode right = new TreeNode(3);
        root.setRight(right);
        left.setLeft(new TreeNode(4));
        left.setRight(new TreeNode(5));
        right.setLeft(new TreeNode(6));
        right.setRight(new TreeNode(7));
        return root;
     }





}
