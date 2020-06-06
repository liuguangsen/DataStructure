package com.liugs.datastructure.tree;

public class SumTree {

    public static void main(String [] args){
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
//        one.setVal(11);
        one.val = 11;
        hebing1(one,two);
        System.out.println(one.val);
//        one.left = two;
        one.right = three;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        four.right = five;

//        print(one);
    }

    public static void hebing1(TreeNode t1,TreeNode t2){
//        t1.setVal(2);
        t1.val = 2;
        System.out.println(t1.val);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public void setVal(int val) {
            this.val = val;
        }

        TreeNode(int x) {
            val = x;
        }
    }

    private static void print(TreeNode node){
        if (node != null){
            System.out.print(node.val);
            print(node.left);
            print(node.right);
        }
    }
}
