package com.cao.tree;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月09日 21:26
 */
public class InOrder {

    public TreeNode next(TreeNode node){
        if(node == null)
            return null;
        if(node.getRight() != null){
            return first(node.getRight());
        }else {
            while(node.getParent() != null && node.getParent().getRight() == node){
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    public TreeNode first(TreeNode node){
        if(node == null)
            return null;
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }

    public void traverse(TreeNode root){
        for(TreeNode node = first(root);node!=null;node = next(node)){
            System.out.print(node.getValue());
        }
        System.out.println();
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

        InOrder in = new InOrder();
        in.traverse(root);

        in.traverse(creater.createTree("",""));
        in.traverse(creater.createTree("A","A"));
        in.traverse(creater.createTree("AB","BA"));
    }
}
