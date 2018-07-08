package com.cao.tree;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月08日 20:45
 */
public class TreeCreater {
    /**
     *              A
     *       B          C
     *    D     E           F
     *        G
     * @return
     */
    public TreeNode createSimpleTree(){
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('G'));
        root.setRight(new TreeNode('C'));
        root.getRight().setRight(new TreeNode('F'));
        return root;
    }

    /**
     * 根据前序和中序构建二叉树
     * 前序的第一位是根节点，中序的左右
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode createTree(String preOrder, String inOrder){
        if(preOrder == null || preOrder.length() == 0)
            return null;
        char rootChar = preOrder.charAt(0);
        TreeNode root = new TreeNode(rootChar);
        int rootIndex = inOrder.indexOf(rootChar);
        root.setLeft(createTree(preOrder.substring(1,1+rootIndex), inOrder.substring(0,rootIndex)));
        root.setRight(createTree(preOrder.substring(1+rootIndex), inOrder.substring(1+rootIndex)));
        return root;
    }

}
