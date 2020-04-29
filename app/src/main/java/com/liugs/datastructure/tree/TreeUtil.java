package com.liugs.datastructure.tree;

public class TreeUtil {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        treeNode.insert(5);
        treeNode.insert(3);
        treeNode.insert(7);
        treeNode.insert(2);
        treeNode.insert(4);
        treeNode.insert(8);
        treeNode.insert(6);

        treeNode.preOrderErgodic(treeNode.header);
        System.out.println("");
        treeNode.middleOrderErgodic(treeNode.header);
        System.out.println("");
        treeNode.afterOrderErgodic(treeNode.header);
//        treeNode.delete(3);
//        treeNode.preOrderErgodic(treeNode.header);
//        System.out.println("");



    }
}
