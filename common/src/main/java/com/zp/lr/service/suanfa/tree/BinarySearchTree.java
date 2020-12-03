package com.zp.lr.service.suanfa.tree;

import org.junit.jupiter.api.Test;

/**
 * @Auther: zhangpanm
 * @Date: 2020/7/4
 * @Description:
 */
public class BinarySearchTree<T> extends BinaryTree{

    private TreeNode<T> root;

    public BinarySearchTree(Comparable<T> data){
        this.root = new TreeNode<T>(data);
    }

    public BinarySearchTree insertData(Comparable<T> data){
        if(null != data){
          insert(root,data);
        }
        return this;
    }

    private void insert(TreeNode<T> root, Comparable<T> data){
        Comparable<T> rdata = root.getData();
        if(data.compareTo((T)rdata)<0){
            TreeNode<T> left = root.getLeftNode();
            if(null ==left ){
                root.setLeftNode(new TreeNode<>(data));
            }else{
                insert(left,data);
            }
        }else{
            TreeNode<T> right = root.getRightNode();
            if(null ==right ){
                root.setRightNode(new TreeNode<>(data));
            }else{
                insert(right,data);
            }
        }
    }

    public boolean findData(Comparable<T> data){
        if(null!=data){
            return null!=find(root,data);
        }
        return  false;
    }
    protected TreeNode<T> find(TreeNode<T> root, Comparable<T> data){
        Comparable<T> rdata = root.getData();
        if(rdata.equals(data)){
            return root;
        }
        if(data.compareTo((T)rdata)<0){
            TreeNode<T> left = root.getLeftNode();
            if(null != left)
               return find(left,data);

        }else{
            TreeNode<T> right = root.getRightNode();
            if(null !=right )
                return find(right,data);
        }
        return null;
    }

    public boolean delData(Comparable<T> data){
        if(null!=data){
            TreeNode<T> curNode=find(root,data);//找到对应的节点
            if(curNode!= null){
               delTreeNode(curNode);
            }
        }
        return  false;
    }

    protected void delTreeNode(TreeNode<T> curNode){
        TreeNode<T> left = curNode.getLeftNode();
        TreeNode<T> right = curNode.getRightNode();
        if(null==left&&null==right){//当前节点是叶子节点，直接数据设置null
            curNode.setData(null);
            return;
        }
        if(null!=left&&null!=right){//左右子节点都不为空
            TreeNode<T> eNode =findExtendsNode(curNode,right);
            curNode.setData(eNode.getData());//将后续节点数据传递给当前节点
            delTreeNode(eNode);//删除后续节点
            return;
        }
        delTreeNode(curNode,left,right);//删除只有一个子节点的当前节点,相当于子节点上移
    }

    /**
     * 查找当前节点的后续节点
     * @param curNode
     * @param rightChild
     * @return
     */
    private TreeNode<T> findExtendsNode(TreeNode<T> curNode,TreeNode<T> rightChild){
      if(null == curNode.getLeftNode()){
          return curNode;
      }
      if(null==rightChild.getLeftNode()){
          return rightChild;
      }
      return   findExtendsNode(rightChild.getLeftNode(),  rightChild.getLeftNode().getRightNode());
    }

    /**
     * 删除只有一个子节点的当前节点
     * @param curNode
     * @param leftChild
     * @param rightChild
     */
    private void delTreeNode(TreeNode<T> curNode,TreeNode<T> leftChild,TreeNode<T> rightChild){
        if(leftChild!=null){
            curNode.setLeftNode(leftChild.getLeftNode());
            curNode.setRightNode(leftChild.getRightNode());
            curNode.setData(leftChild.getData());
            return;
        }
        if(rightChild!=null){
            curNode.setLeftNode(rightChild.getLeftNode());
            curNode.setRightNode(rightChild.getRightNode());
            curNode.setData(rightChild.getData());
            return;
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    @Test
    public void testb(){


    }

    public static void main(String[] args) {
        Integer [] data = {20,4,5,87,30,51,80,76,48,31,49,64,31};
        BinarySearchTree<Integer> bst = new BinarySearchTree(50);
        for(Integer s : data){
            bst.insertData(s);
        }
        System.out.println("leef:");
        bst.leefAccess(bst.getRoot());



        System.out.println("midAccess:");
        bst.midAccess(bst.getRoot());



        bst.delData(50);
        System.out.println("midAccess:");
        bst.midAccess(bst.getRoot());


        System.out.println("leef:");
        bst.leefAccess(bst.getRoot());
        String dd ="ddd";


    }

}
