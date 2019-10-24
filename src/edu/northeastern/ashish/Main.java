package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        Integer[] preOrder = {1,2,4,8,5,9,3,6,10,7, 11};
        Integer[] inOrder = {8,4,2,9,5,1,6,10,3,7,11};
        tree.root = tree.getTreeFromInorderAndPreorder(preOrder, inOrder);

        //tree.root = CreateTree();

       // tree.sumFromRootToLeaf(tree.root);

        tree.levelOrder();
    }



    /**
     * Function to create following tree
     *
     *                     1 -> null
     *                  /     \
     *                 2  ->    3 -> null
     *               /  \     /  \
     *             4 - > 5 ->6 ->  7 -> null
     *           /      /     \     \
     *         8  ->  9  ->  10  -> 11 -> null
     */

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
