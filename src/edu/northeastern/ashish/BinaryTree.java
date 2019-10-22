package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree(){
        root = null;
    }

    //Wrapper function for Pre Order
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    //recursive pre order
    private void preOrder(Node<T> node){
        if(node != null){
            System.out.print(node.data + " ,");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    // Wrapper function for post order
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    // recursive function for post order
    private void postOrder(Node<T> node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ,");
        }
    }

    // Wrapper function for in order
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    // recursive function for in order
    private void inOrder(Node<T> node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + " ,");
            inOrder(node.right);
        }
    }
    // wrapper function for size
    public int size(){
        return size(root);
    }
    // 
    public int size(Node<T> node){
        if(node == null)
            return 0;
        // size of the tree would be size of its left + Size of right + 1 (Own size)
        return size(node.left) + 1 + size(node.right);
    }

    // wrapper function for height
    public int height(){
        return height(root);
    }
    // recursive function for height
    private int height(Node<T> node){
        if(node == null)
            return 0;
        // get height of left and right side
        int left = height(node.left);
        int right = height(node.right);

        // height will be Max of height of left and right + 1 (Own level)
        return 1 + Math.max(left, right );

    }
    
    // Level order iterative which prints every level at one line
    public void levelOrder(){
        if(root == null)
            return;

        // Take a queue and enqueue root and null
        // every level ending is signified by null
        // since there is just one node at root we enqueue root as well as null
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        
        while(queue.size() != 0){
            
            Node<T> node = queue.remove();
            // If the node is not null print it and enqueue its left and right child 
            // if they exist
            if(node != null){
                System.out.print(node.data + " ,");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                // We have reached a new level 
                // Check is queue is empty, if yes then we are done 
                // otherwise print a new line and enqueue a new null for next level
                System.out.println();
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    // Similar to level order traversal 
    // we will print the left most node of a level once a node is printed we will
    // not print remaining nodes for that level;
    public void printLeftView(){
        if(root == null)
            return;

        // Take a queue and enqueue root and null
        // every level ending is signified by null
        // since there is just one node at root we enqueue root as well as null
        // take a bool value printed = false
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean printed = false;

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                // if the first node is not printed print it and flip the bool value
                if(! printed){
                    System.out.println(node.data);
                    printed = true;
                }

                // add left and right child if they exist
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                // flip the printed bool value
                // break if the queue is empty else enqueue a null
                printed = false;
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    // Similar to level order traversal 
    // we will print the right most node by keeping track of last node 
    // when we change levels we will print the last node
    public void printRightView(){
        
        if(root == null)
            return;

        // Take a queue and enqueue root and null
        // every level ending is signified by null
        // since there is just one node at root we enqueue root as well as null
        // take a bool value printed = false
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> lastVal = null;

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){

                // keep track of last node and dont print it
                lastVal = node;

                // Enqueue left and right child if they exist
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                // print last node
                System.out.println(lastVal.data + " ,");
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    // Similar to level order traversal
    // we will keep a bool print. if print is true we print the nodes,
    // else we add nodes in stack. Once we go to next level
    // we empty stack and print all the nodes in stack
    public void printZigZag(){
        if(root == null)
            return;

        // add root and null to queue, declare bool value print and a stack
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean print = true;
        Stack<Node<T>> stack = new Stack<Node<T>>();

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                // if print is true print the node else add it in stack
                if(print)
                    System.out.print(node.data + " ,");
                else
                    stack.push(node);

                // add left and right node if they exist
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                // flip print and empty stack and print
                print = !print;
                while(stack.size() != 0){
                    System.out.print(stack.pop().data + " ,");
                }
                System.out.println();
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }

        // check if there is any remaining elements in stack
        while(stack.size() != 0){
            System.out.print(stack.pop().data + " ,");
        }
        System.out.println();
    }

}
