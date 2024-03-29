package com.qdm.datastruct.lc.tree;

import com.google.common.collect.Lists;
import com.qdm.datastruct.util.PrintUtil;

import java.util.*;

/**
 * 遍历二叉树
 */
public class TreeNodeFor {


    public static void main(String[] args) {
        TreeNode root = TreeNodeData.getInitTreeData();

//        List<Integer> list = preOrderTreeNode(root);


//        List<Integer> list = frontOrder(root);

        List<Integer> list = new ArrayList<>();
        inOrderWithStack(root, list);
        PrintUtil.printList(list);

    }


    /**
     * 先序遍历
     * @param root
     * @return
     */
    private static List<Integer> preOrderTreeNode(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preOrder1(root, list);
//        return list;


        return preOrderWithStack(root);
    }


    /**
     * 递归方式
     * @param treeNode
     * @param list
     */
    private static void preOrder1(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.getVal());
        preOrder1(treeNode.getLeft(), list);
        preOrder1(treeNode.getRight(), list);
    }



    private static List<Integer> preOrderWithStack(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while ( node !=null) {
                list.add(node.getVal());
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            node = node.getRight();
        }

        return list;
    }


    /**
     * 后续遍历
     * @param root
     * @return
     */
    private static List<Integer> frontOrder(TreeNode root) {
        List<Integer> list = Lists.newArrayList();
        frontOrder1(root, list);
        return list;
    }

    //后续
    private static void frontOrder1(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        frontOrder1(node.getLeft(), list);
        frontOrder1(node.getRight(), list);
        list.add(node.getVal());
    }


    private static void inOrder(TreeNode treeNode, List<Integer> list) {
        if(treeNode == null) {
            return;
        }
        inOrder(treeNode.getLeft(), list);
        list.add(treeNode.getVal());
        inOrder(treeNode.getRight(), list);
    }



    private static void inOrderWithStack(TreeNode treeNode, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            treeNode = stack.pop();
            list.add(treeNode.getVal());
            treeNode = treeNode.getRight();
        }
    }












}
