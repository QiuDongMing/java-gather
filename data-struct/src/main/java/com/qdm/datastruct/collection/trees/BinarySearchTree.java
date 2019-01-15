package com.qdm.datastruct.collection.trees;

/**
 * @author qiudm
 * @date 2019/1/14 15:09
 * @desc BST树 即二叉搜索树
 * <p>
 * 1.所有非叶子结点至多拥有两个儿子（Left和Right）；
 * 2.所有结点存储一个关键字；
 * 3.非叶子结点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树；
 */
public class BinarySearchTree {

    private TreeNode rootNode;

    public void insert(int data) {
        rootNode = insert(data, rootNode);
    }

    private TreeNode insert(int data, TreeNode treeNode) {
        if (treeNode == null) {
            return new TreeNode(data, null, null);
        } else {
            int nodeData = treeNode.data;
            if (nodeData > data) {
                treeNode.left = insert(data, treeNode.left);
            } else if (nodeData < data) {
                treeNode.right = insert(data, treeNode.right);
            }
        }
        return treeNode;
    }


    public void printTree() {
        printTree(rootNode);
    }

    private void printTree(TreeNode treeNode) {
        if (treeNode != null) {
            printTree(treeNode.left);
            System.out.println("treeNode.data = " + treeNode.data);
            printTree(treeNode.right);
        }
    }


    class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.printTree();
    }


}
