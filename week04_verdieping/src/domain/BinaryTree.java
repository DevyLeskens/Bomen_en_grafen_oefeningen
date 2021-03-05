package domain;

import java.util.ArrayList;

public class BinaryTree<E extends Comparable> {
    E data;
    BinaryTree<E> leftTree, rightTree;

    public BinaryTree(E data) {
        this(data, null, null);
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public void printPreorder() {
        System.out.print(this.data + " ");
        if (this.leftTree != null) this.leftTree.printPreorder();
        if (this.rightTree != null) this.rightTree.printPreorder();
    }

    public void printInorder() {
        if (this.leftTree != null) this.leftTree.printInorder();
        System.out.print(this.data + " ");
        if (this.rightTree != null) this.rightTree.printInorder();
    }

    public void printPostorder() {
        if (this.leftTree != null) this.leftTree.printPostorder();
        if (this.rightTree != null) this.rightTree.printPostorder();
        System.out.print(this.data + " ");
    }

    public int countNodes() {
        return 1 + (leftTree != null ? leftTree.countNodes() : 0) + (rightTree != null ? rightTree.countNodes() : 0);
    }

    public int getDepth() {
        return 1 + Math.max((leftTree != null ? leftTree.getDepth() : 0), (rightTree != null ? rightTree.getDepth() : 0));
    }

    public boolean isLeaf() {
        return leftTree == null && rightTree == null;
    }

    public int countLeaves() {
        if (isLeaf()) return 1;

        return (leftTree != null ? leftTree.countLeaves() : 0) + ((rightTree != null) ? rightTree.countLeaves() : 0);
    }

    public ArrayList<E> getDataLeaves() {
        ArrayList<E> dataLeaveslist = new ArrayList<>();
        if (isLeaf()) {
            dataLeaveslist.add(this.data);
            return dataLeaveslist;
        }
        if (leftTree != null) {
            dataLeaveslist.addAll(leftTree.getDataLeaves());
        }
        if (rightTree != null) {
            dataLeaveslist.addAll(rightTree.getDataLeaves());
        }
        return dataLeaveslist;
    }

    public boolean contains(E data) {
        if (data == null) return false;
        if (this.data == data) return true;

        return (leftTree != null && leftTree.contains(data)) || (rightTree != null && rightTree.contains(data));

    }

    public int count(E data) {
        int counter = 0;
        if (data.compareTo(this.data) == 0) {
            counter++;
        }
        if (this.leftTree != null) {
            counter += this.leftTree.count(data);
        }
        if (this.rightTree != null) {
            counter += this.rightTree.count(data);
        }

        return counter;
    }

    public ArrayList<E> getNodesAtDistance(int distance) {
        ArrayList<E> nodes = new ArrayList<E>();
        if (distance == 0) {
            nodes.add(this.data);
        } else {
            if (leftTree != null) {
                nodes.addAll(leftTree.getNodesAtDistance(distance - 1));
            }
            if (rightTree != null) {
                nodes.addAll(rightTree.getNodesAtDistance(distance - 1));
            }
        }
        return nodes;
    }

    public boolean kinderSom() {
        return true;
    }


    public boolean addNode(E data) {
        return true;
    }

    public boolean lookup(E data) {
        return true;
    }

    public E searchGreatest() {
        return null;
    }

    public E searchSmallest() {
        return null;
    }

    protected boolean removeNode(E data) {
        return true;
    }

    public ArrayList<E> getPath(E data) {
        return null;
    }
}