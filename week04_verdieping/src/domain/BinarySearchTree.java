package domain;

import java.util.ArrayList;

/*
Update the BinaryTree class in the domain folder with the BinaryTree of week 02
* */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        super(data, leftTree, rightTree);
    }

    public BinarySearchTree(E data) {
        super(data);
    }

    @Override
    public boolean lookup(E data) {
        if (data.compareTo(this.data) == 0) {
            return true;
        } else {
            if (data.compareTo(this.data) < 0) {
                if (leftTree == null) {
                    return false;
                } else {
                    return leftTree.lookup(data);
                }
            } else {
                if (rightTree == null) {
                    return false;
                } else {
                    return rightTree.lookup(data);
                }
            }
        }
    }

    @Override
    public boolean addNode(E data) {
        if (data.compareTo(this.data) == 0) return false;
        else {
            if (data.compareTo(this.data) < 0) {
                if (leftTree == null) {
                    leftTree = new BinarySearchTree<E>(data);
                    return true;
                } else {
                    return leftTree.addNode(data);
                }
            } else {
                if (rightTree == null) {
                    rightTree = new BinarySearchTree<E>(data);
                    return true;
                } else {
                    return rightTree.addNode(data);
                }
            }
        }
    }

    @Override
    public boolean removeNode(E data) {
        if (data.compareTo(this.data) == 0) {
            this.data = null;
            return false;
        } else {
            if (data.compareTo(this.data) < 0) {
                if (leftTree == null) {
                    return false;
                } else {
                    return leftTree.removeNode(data);
                }
            } else {
                if (rightTree == null) {
                    return false;
                } else {
                    return rightTree.removeNode(data);
                }
            }
        }
    }

    @Override
    public E searchSmallest() {
        if (leftTree == null) {
            return this.data;
        } else {
            return leftTree.searchSmallest();
        }
    }

    @Override
    public E searchGreatest() {
        if (rightTree == null) {
            return this.data;
        } else {
            return rightTree.searchGreatest();
        }
    }

    @Override
    public ArrayList<E> getPath(E data) {
        if (!lookup(data)) return null;

        ArrayList<E> path = new ArrayList<E>();

        if (data.compareTo(this.data) == 0) {
            path.add(data);
            return path;
        }
        if (data.compareTo(this.data) > 0) {
            path.add(this.data);
            path.addAll(rightTree.getPath(data));
        }
        if (data.compareTo(this.data) < 0) {
            path.add(this.data);
            path.addAll(leftTree.getPath(data));
        }

        return path;

    }
}


