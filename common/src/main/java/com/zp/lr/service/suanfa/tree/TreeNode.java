package com.zp.lr.service.suanfa.tree;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/28
 * @Description:
 */
public class TreeNode<T> {

    private Comparable<T> data;

    private TreeNode<T> leftNode;

    private TreeNode<T> rightNode;

    public TreeNode(Comparable<T> data) {
        this.data = data;
    }

    public TreeNode(Comparable<T> data, TreeNode<T> leftNode) {
        this.data = data;
        this.leftNode = leftNode;
    }

    public TreeNode(Comparable<T> data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Comparable<T> getData() {
        return data;
    }

    public void setData(Comparable<T> data) {
        this.data = data;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
