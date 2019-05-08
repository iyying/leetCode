package solutions;

import utils.BinarySearchTree;
import utils.TreeNode;

class p1038 {
    private static BinarySearchTree binarySearchTree;
    private static int rightSum = 0;

    private static void bstToGst(TreeNode root) {
        solutionPostOrder(root);
    }

    public static void main(String[] args) {
        int[] vals = {4, 1, 6, 0, 2, 5, 7, 3, 8};
        binarySearchTree = genBst(vals);

        binarySearchTree.levelTraversal(binarySearchTree.getMe());
        System.out.println("\n");

        bstToGst(binarySearchTree.getMe());

        binarySearchTree.levelTraversal(binarySearchTree.getMe());
    }

    public static void solutionPostOrder(TreeNode node) {

        if (node != null) {
            solutionPostOrder(node.right);

            System.out.println(node.val + "->" + (node.val + rightSum));

            node.val = node.val + rightSum;
            rightSum = node.val;

            solutionPostOrder(node.left);
        }
    }

    private static BinarySearchTree genBst(int[] vals) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int val : vals) {
            TreeNode treeNode = new TreeNode(val);
            binarySearchTree.insert(treeNode);
        }

        return binarySearchTree;
    }
}
