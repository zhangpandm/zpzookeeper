package com.zp.lr.service.suanfa.tree;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/28
 * @Description:
 */
public class BinaryTree {
    @Test
    public void testA(){
        TreeNode<Character> F = new TreeNode<Character>('F');
        TreeNode<Character> K = new TreeNode<Character>('K');
        TreeNode<Character> M = new TreeNode<Character>('M');
        TreeNode<Character> I = new TreeNode<Character>('I');
        TreeNode<Character> E = new TreeNode<Character>('E',F);
        TreeNode<Character> D = new TreeNode<Character>('D',null,E);
        TreeNode<Character> B = new TreeNode<Character>('B',D);
        TreeNode<Character> J = new TreeNode<Character>('J',K,M);
        TreeNode<Character> G = new TreeNode<Character>('G',null,I);
        TreeNode<Character> H = new TreeNode<Character>('H',J);
        TreeNode<Character> C = new TreeNode<Character>('C',G,H);
        TreeNode<Character> root = new TreeNode<Character>('A',B,C);

        //midAccess(root);
        leefAccess(root);
    }

    /**
     * 前序遍历
     * @param root
     */
    public  void preAccess(TreeNode root){
            if(null!=root){
                System.out.println(root.getData());
                TreeNode left = root.getLeftNode();
                TreeNode right = root.getRightNode();
                if(left!=null){//遍历左节点
                    preAccess(left);
                }
                if(right!=null){//遍历右节点
                    preAccess(right);
                }
            }
    }

    /**
     * 中序遍历
     * @param root
     */
    public  void midAccess(TreeNode root){
        if(null!=root){
            TreeNode left = root.getLeftNode();
            TreeNode right = root.getRightNode();
            if(left!=null){//遍历左节点
                midAccess(left);
            }
            System.out.println(root.getData());
            if(right!=null){//遍历右节点
                midAccess(right);
            }
        }
    }

    /**
     * 后续遍历
     * @param root
     */
    public  void backAccess(TreeNode root){
        if(null!=root){
            TreeNode left = root.getLeftNode();
            TreeNode right = root.getRightNode();
            if(left!=null){//遍历左节点
                backAccess(left);
            }
            if(right!=null){//遍历右节点
                backAccess(right);
            }
            System.out.println(root.getData());
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public  void leefAccess(TreeNode root){
        if(null != root){
            Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
            queue.add(root);
            System.out.println("root:"+root.getData());
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i=0;i<size;i++){
                    TreeNode cNode = queue.poll();
                    TreeNode leftNode = cNode.getLeftNode();
                    TreeNode rightNode = cNode.getRightNode();
                    if(null !=leftNode){
                        queue.add(leftNode);
                        System.out.print("~:"+leftNode.getData());
                    }else{
                        System.out.print("~: ");

                    }
                    if(null !=rightNode){
                        queue.add(rightNode);
                        System.out.print("*:"+rightNode.getData());
                    }else{
                        System.out.print("*: ");

                    }
                    System.out.print("  ");
                }
                System.out.println();

            }
        }
    }



}
