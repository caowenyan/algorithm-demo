package com.cao.tree;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月08日 20:51
 */
public class TreeTraversal {

    /**
     * 前序遍历，前：指根节点位于第一位
     * @param root
     */
    public void preOrder(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(TreeNode root){
        if(root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }

    /**
     *              A
     *       B          C
     *    D     E           F
     *        G
     * @return
     */
    public static void main(String[] args) {
        TreeCreater creater = new TreeCreater();
        TreeNode root = creater.createSimpleTree();

        TreeTraversal traversal = new TreeTraversal();
        traversal.preOrder(root);
        System.out.println();
        traversal.inOrder(root);
        System.out.println();
        traversal.postOrder(root);
        System.out.println();
    }
}
