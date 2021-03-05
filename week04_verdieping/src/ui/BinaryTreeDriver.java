package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        //bladeren
        BinaryTree<String> leftTree2 = new BinaryTree<>("C", null, new BinaryTree<>("E"));

        BinaryTree<String> rightTree2 = new BinaryTree<>("H", leftTree2, new BinaryTree<>("E"));

        BinaryTree<String> leftTree1 = new BinaryTree<>("H", new BinaryTree<>("A"), rightTree2);



        BinaryTree<String> leftTree3 = new BinaryTree<>("H", null, new BinaryTree<>("E"));

        BinaryTree<String> rightTree3 = new BinaryTree<>("I", leftTree3, new BinaryTree<>("E"));

        BinaryTree<String> rightTree1 = new BinaryTree<>("G", null, rightTree3);



        BinaryTree<String> boom = new BinaryTree<>("A", leftTree1, rightTree1);

        boom.printPreorder();
        System.out.println("\n");
        boom.printInorder();
        System.out.println("\n");
        boom.printPostorder();

        System.out.println("\n");
        System.out.println(boom.count("E"));

        System.out.println("\n");
        System.out.println(boom.getNodesAtDistance(5));


    }
}