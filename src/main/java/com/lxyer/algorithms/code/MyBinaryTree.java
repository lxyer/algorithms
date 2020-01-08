package com.lxyer.algorithms.code;
import	java.util.Queue;


import java.util.LinkedList;
import java.util.Stack;

public class MyBinaryTree {
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer root = inputList.removeFirst();
        if (root != null) {
            node = new TreeNode(root);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历(递归)
     *
     * @param node
     */
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二叉树中序遍历(递归)
     *
     * @param node
     */
    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    /**
     * 二叉树后序遍历(递归)
     *
     * @param node
     */
    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    /**
     * 二叉树非递归前序遍历
     *
     * @param node
     */
    public static void preOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点左孩子,并入栈
            if (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果左孩子没有了,则弹出栈顶节点,访问节点右孩子
            if (!stack.empty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 二叉树层序遍历-广度优先
     *
     * @param node
     */
    public static void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }

    public static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public TreeNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
