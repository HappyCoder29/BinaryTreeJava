package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.root = CreateTree();

        tree.levelOrder();
    }

    private static Node<Integer> CreateTree(){
        Node<Integer> root = new Node<Integer>(1);

        // first level
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);

        // Second Level
        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
        root.right.left = new Node<Integer>(6);
        root.right.right = new Node<Integer>(7);

        // Third level

        root.left.left.left = new Node<Integer>(8);
        root.left.right.left = new Node<Integer>(9);
        root.right.left.right = new Node<Integer>(10);
        root.right.right.right = new Node<Integer>(11);

        return  root;
    }
}
