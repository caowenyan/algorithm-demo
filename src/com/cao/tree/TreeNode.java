package com.cao.tree;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月08日 20:44
 */
public class TreeNode<E> {
    private E value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(E value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
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
