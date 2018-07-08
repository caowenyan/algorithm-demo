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
}
