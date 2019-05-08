package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    /**
     * 二叉查找树根节点
     */
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode getMe() {
        return this.root;
    }
    /**
     * 前序遍历
     * @param node 待遍历二叉查找树BST根节点
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        } else {
            System.out.print("null ");
        }
    }

    /**
     * 中序遍历
     * @param node 待遍历BST根节点
     */
    public void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.val + " ");
            midOrder(node.right);
        } else {
            System.out.print("null ");
        }
    }

    /**
     * 后序遍历
     * @param node 待遍历BST根节点
     */
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ");
        } else {
            System.out.print("null ");
        }
    }

    /**
     * 广度优先遍历（层次遍历）
     * @param node 待遍历BST根节点
     */
    public void levelTraversal(TreeNode node)
    {
        // 利用队列先进先出的特性， 层层输出
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.add(root);
        }

        while (nodeQueue.size() != 0)
        {
            TreeNode currentNode = nodeQueue.poll();

            System.out.print(currentNode.val + " ");
            // 将去除节点的子节点添加到队列的尾部
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
            }
        }
    }

    /**
     * 在二叉查找树bst中插入新节点newNode
     * @param newNode
     * @return
     */
    public boolean insert(TreeNode newNode) {
        //如果root为空，则新节点作为根节点
        TreeNode root = this.root;
        if(root == null) {
            this.root = newNode;
            return true;
        }
        while(root != null) {
            int cmp = newNode.val - root.val;

            if(cmp < 0) {
                //小于，在左边插入
                if(root.left == null) {
                    root.left = newNode;
                    return true;
                } else {
                    root = root.left;
                }
            } else if(cmp > 0) {
                //大于，在右边插入
                if(root.right == null) {
                    root.right = newNode;
                    return true;
                } else {
                    root = root.right;
                }
            } else {
                //等于，则插入失败，返回false
                return false;
            }
        }
        return false;
    }
}
