package com.qdm.datastruct.lc.tree;

public class TreeHeight {


    public static void main(String[] args) {
        TreeNode node = TreeNodeData.getInitTreeData();
        System.out.println("getHeight(node) = " + getHeight(node));
    }



    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int hLeft = getHeight(node.getLeft());
        int hRight = getHeight(node.getRight());
        return Math.max(hLeft, hRight) + 1;
    }



}
