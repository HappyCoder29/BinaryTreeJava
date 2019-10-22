package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree(){
        root = null;
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    public void preOrder(Node<T> node){
        if(node != null){
            System.out.print(node.data + " ,");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    public void postOrder(Node<T> node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ,");
        }
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    public void inOrder(Node<T> node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + " ,");
            inOrder(node.right);
        }
    }
    public int size(){
        return size(root);
    }
    public int size(Node<T> node){
        if(node == null)
            return 0;

        return size(node.left) + 1 + size(node.right);
    }

    public int height(){
        return height(root);
    }
    private int height(Node<T> node){
        if(node == null)
            return 0;
        int left = height(node.left);
        int right = height(node.right);

        return 1 + Math.max(left, right );

    }
    public void levelOrder(){
        if(root == null)
            return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                System.out.print(node.data + " ,");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                System.out.println();
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    public void printLeftView(){
        if(root == null)
            return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean printed = false;

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                if(! printed){
                    System.out.print(node.data + " ,");
                    printed = true;
                }

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                System.out.println();
                printed = false;
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    public void printRightView(){
        if(root == null)
            return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> lastval = null;

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){

                lastval = node;
                //Console.Write(node.data + " ,");


                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                System.out.println(lastval.data + " ,");
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    public void printZigZag(){
        if(root == null)
            return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean print = true;
        Stack<Node<T>> stack = new Stack<Node<T>>();

        while(queue.size() != 0){
            Node<T> node = queue.remove();
            if(node != null){
                if(print)
                    System.out.print(node.data + " ,");
                else
                    stack.push(node);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
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
        while(stack.size() != 0){
            System.out.print(stack.pop().data + " ,");
        }
        System.out.println();
    }

}
