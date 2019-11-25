package com.liugs.datastructure.tree;


public class TreeNode extends Node {
    private static final String TAG = "TreeNode";
    public Node header;

    public TreeNode() {
        this.header = new Node();
    }

    public void preOrderErgodic(Node node) {
        if (node == null) {
            return;
        }
        // 前序遍历 第一次遍历到Node就打印出来
        System.out.print(node.data + " ");
        preOrderErgodic(node.leftChild);
        preOrderErgodic(node.rightChild);
    }

    public void middleOrderErgodic(Node node) {
        if (node == null) {
            return;
        }
        middleOrderErgodic(node.leftChild);
        // 前序遍历 第二次遍历到Node就打印出来
        System.out.print(node.data + " ");
        middleOrderErgodic(node.rightChild);
    }

    public void afterOrderErgodic(Node node) {
        if (node == null) {
            return;
        }
        afterOrderErgodic(node.leftChild);
        afterOrderErgodic(node.rightChild);
        // 前序遍历 第三次遍历到Node就打印出来
        System.out.print(node.data + " ");
    }

    public Node search(int data) {
        return search(header, data);
    }

    private Node search(Node node, int data) {
        if (node == null) {
            // 1.检查node
            return null;
        } else if (node.data == data) {
            // 2.对比node
            return node;
        } else {
            Node leftChild = node.leftChild;
            Node rightChild = node.rightChild;
            if (leftChild != null) {
                // 3.对比node的左子树
                return search(leftChild, data);
            } else if (rightChild != null) {
                // 4.对比node的右子树
                return search(rightChild, data);
            } else {
                // 5.查找不到就返回为null
                return null;
            }
        }
    }

    public void insert(int data) {
        insert(header, data);
    }

    private void insert(Node node, int data) {
        if (node != null) {
            int currentNodeData = node.data;
            if (data < currentNodeData) {
                // 放左边
                Node leftChild = node.leftChild;
                if (leftChild == null) {
                    Node newNode = new Node(data);
                    node.leftChild = newNode;
                    newNode.parent = node;
                } else {
                    insert(leftChild, data);
                }
            } else if (data > currentNodeData) {
                // 放右边
                Node rightChild = node.rightChild;
                if (rightChild == null) {
                    Node newNode = new Node(data);
                    node.rightChild = newNode;
                    newNode.parent = node;
                } else {
                    insert(rightChild, data);
                }
            }
        }
    }

    public void delete(int data) {
        Node search = search(data);
        delete(search, data);
    }

    private void delete(Node node, int data) {
        if (node != null) {
            Node leftChild = node.leftChild;
            Node rightChild = node.rightChild;
            Node parent = node.parent;
            boolean isLeftChild = parent.leftChild == node;

            if (leftChild == null && rightChild != null) {
                rightChild.parent = parent;
                if (isLeftChild) {
                    parent.leftChild = rightChild;
                } else {
                    parent.rightChild = rightChild;
                }
            } else if (leftChild != null && rightChild == null) {
                leftChild.parent = parent;
                if (isLeftChild) {
                    parent.leftChild = leftChild;
                } else {
                    parent.rightChild = leftChild;
                }
            } else if (leftChild != null) {
                // 如果两个子view都不是空的
                // 右子树直接上升
                // 把左子树统统嫁接到右子树的最左子也节点
                parent.leftChild = rightChild;
                rightChild.parent = parent;
                // 找到右子树的最左子叶节点
                Node lastLeftChild = findLeftChild(rightChild);
                lastLeftChild.leftChild = leftChild;
                leftChild.parent = lastLeftChild;
            } else {
                if (isLeftChild) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            }
        }
    }

    public Node findLeftChild(Node node) {
        if (node.leftChild == null) {
            return node;
        } else {
            return findLeftChild(node.rightChild);
        }
    }
}
