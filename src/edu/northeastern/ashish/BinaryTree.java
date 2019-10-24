package edu.northeastern.ashish;

import javax.lang.model.type.MirroredTypeException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
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

    public boolean isBalancedTree(Node<T> node){
        if(node == null)
            return  true;

        return  Math.abs(height(node.left) -height(node.right)) < 2
                && isBalancedTree(node.left)
                && isBalancedTree(node.right);

    }

    public boolean isSameTree(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null)
            return true;

        if(node1 == null ||  node2 == null)
            return  false;

        return  node1.data == node2.data
                && isSameTree(node1.left, node2.left)
                && isSameTree(node1.right, node2.right);

    }

    public boolean isSubTree(Node<T> subTree, Node<T> tree){
        return  isSameTree(subTree, tree)
                || isSameTree(subTree, tree.left)
                || isSameTree(subTree, tree.right);

    }

    public void mirrorTree(){
        mirrorTree(root);
    }
    private void mirrorTree(Node<T> node){
        if(node == null)
            return;

        //post order
        mirrorTree(node.left);
        mirrorTree(node.right);

        // swap nodes
        Node temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private boolean isIsomorphic(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null)
            return  true;
        if(node1 == null || node2 == null)
            return  false;
        return  isIsomorphic(node1.left, node2.left) &&
                isIsomorphic(node1.right, node2.right);

    }

    public boolean isFoldable(){
        return  isFoldable(root);
    }
    private boolean isFoldable(Node<T> node){

        if(node == null)
            return  true;

        mirrorTree(node.left);

        boolean result = isIsomorphic(node.left, node.right);
        mirrorTree(node.left);
        return  result;
    }


    public boolean isContiniousTree(Node<Integer> node){

        if(node == null)
            return  true;


        if(node.left == null && node.right == null)
            return true;

        if(node.left == null){
            return  Math.abs(node.data - node.right.data) <=1 &&
                    isContiniousTree(node.right);
        }

        if(node.right == null) {
            return Math.abs(node.data - node.left.data) <= 1 &&
                    isContiniousTree(node.left);
        }

        return  Math.abs(node.data - node.left.data) <=1 &&
                Math.abs(node.data - node.right.data) <=1  &&
                isContiniousTree(node.left)&&
                isContiniousTree(node.right);

    }

    public void printAllRootToLeaf(Node<Integer> node){
        if(node == null)
            return;
        ArrayList<Integer> list = new ArrayList<>();
        printAllRootToLeaf(node, list, 0);

    }

    private void printAllRootToLeaf(Node<Integer> node, ArrayList<Integer>  list, int ptr){

        if(node == null)
            return;

        list.add(ptr, node.data);

        // leaf node
        if(node.left == null && node.right == null){
            // print the array till the ptr
            for(int i = 0 ; i <= ptr; i ++){
                System.out.print(list.get(i) + ", ");
            }
            System.out.println();
            return;
        }
        else{
            printAllRootToLeaf(node.left, list, ptr +1 );
            printAllRootToLeaf(node.right, list, ptr +1 );
        }

    }


    private int findIndex(T[] arr, int start, int end, T val){
        for(int i = start ; i < end; i ++){
            if(arr[i].equals(val))
                return  i;
        }
        return  -1;
    }

    public void sumFromRootToLeaf(Node<Integer> node){
        if(node == null)
            return;
        ArrayList<Integer> list = new ArrayList<>();
        sumFromRootToLeaf(node, list, 0);

    }

    private void sumFromRootToLeaf(Node<Integer> node, ArrayList<Integer>  list, int ptr){

        if(node == null)
            return;

        list.add(ptr, node.data);

        // leaf node
        if(node.left == null && node.right == null){
            // print the array till the ptr
            int sum = 0;
            for(int i = 0 ; i <= ptr; i ++){
                sum += list.get(i);
                //System.out.print(list.get(i) + ", ");
            }
            System.out.println(sum);
            return;
        }
        else{
            sumFromRootToLeaf(node.left, list, ptr + 1 );
            sumFromRootToLeaf(node.right, list, ptr +1 );
        }

    }

    public void populateNextRight(){

    }

    public  boolean hasPathSum(Node<Integer> node, int sum){

        if(node == null){
            return  sum == 0;
        }
        else{
            boolean ans = false;

            int subSum = sum - node.data;
            if(subSum == 0 && node.left == null && node.right == null){
                return  true;
            }

            if(node.left != null)
                ans = ans || hasPathSum(node.left , subSum);
            if(ans == true)
                return  true;
            if(node.right != null)
                ans = ans || hasPathSum(node.right , subSum);
            return  ans;
        }
    }// end of function


    public Node<T> getTreeFromInorderAndPreorder(T[] preorder, T[] inOrder){

        int preIndex = 0;

        return  getTreeFromInorderAndPreorder(preorder, inOrder, preIndex, 0,  inOrder.length -1);
    }
    public Node<T> getTreeFromInorderAndPreorder(T[] preOrder, T[] inOrder, int preIndex, int start, int end){

        if( start > end)
            return null;

        Node<T> node = new Node(preOrder[preIndex]);
        preIndex ++;

        int inOrderIndex = findIndex(inOrder, start, end, node.data);

        node.left = getTreeFromInorderAndPreorder(preOrder, inOrder, preIndex, start, inOrderIndex -1);
        node.right = getTreeFromInorderAndPreorder(preOrder, inOrder, preIndex, inOrderIndex +1, end);
        return  node;
    }


}
