package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        //bladeren
        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeC = new BinaryTree<>("C");
        BinaryTree<String> nodeE = new BinaryTree<>("E");
        BinaryTree<String> nodeH = new BinaryTree<>("H");
        BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
        BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);
        BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
        // boom heeft root C en heeft links A en rechts G
        BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);
        boom.printPreorder();
        System.out.println("\n");
        boom.printInorder();
        System.out.println("\n");
        boom.printPostorder();

        System.out.println("\n");
        System.out.println(boom.countNodes());

        System.out.println("\n");
        System.out.println(boom.getDepth());

        System.out.println("\n");
        System.out.println(nodeA.isLeaf());

        System.out.println("\n");
        System.out.println(boom.getDepth());

        System.out.println("\n");
        System.out.println(boom.getDataLeaves());

        System.out.println("\n");
        System.out.println(boom.contains("E"));

    }
}