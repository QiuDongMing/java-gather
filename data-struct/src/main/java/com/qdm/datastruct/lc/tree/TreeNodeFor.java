package com.qdm.datastruct.lc.tree;

import com.qdm.datastruct.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 遍历二叉树
 */
public class TreeNodeFor {


    public static void main(String[] args) {
        TreeNode root = TreeNodeData.getInitTreeData();

        List<Integer> preRes = preOrderTreeNode(root);
        PrintUtil.printList(preRes);

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







}
