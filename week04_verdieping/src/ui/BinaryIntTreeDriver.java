package ui;

import domain.BinaryIntTree;
import domain.BinaryTree;

public class BinaryIntTreeDriver {
    public static void main(String[] args) {
        BinaryIntTree<Number> boom = new BinaryTree<Integer>(7, leftTree1, rightTree1);

        boom.printPreorder();
        System.out.println("\n");
        boom.printInorder();
        System.out.println("\n");
        boom.printPostorder();
        System.out.println("\n");

    }
}
