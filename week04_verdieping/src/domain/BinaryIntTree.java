package domain;

import ui.BinaryIntTreeDriver;

public class BinaryIntTree<Integer> extends BinaryTree<java.lang.Integer> {

    public BinaryIntTree(int data) {
        super(data);
    }

    public BinaryIntTree(int data, BinaryIntTree<Integer> lefttree, BinaryIntTree<Integer> righttree) {
        super(data, lefttree, righttree);
    }

    public boolean kinderSom() {
        boolean result = true;

        if (isLeaf()) return true;

        int left = (leftTree.data != null ? leftTree.data : 0);
        int right = (rightTree.data != null ? rightTree.data : 0);

        if (!isLeaf() && left + right != this.data) {
            result = false;
        }

        return result && leftTree.kinderSom() && rightTree.kinderSom();
    }

}
