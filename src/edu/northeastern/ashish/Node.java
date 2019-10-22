package edu.northeastern.ashish;

public class Node<T> {

    public T data;
    public Node<T> left = null;
    public Node<T> right = null;
    public Node<T> parent = null;

    private Node(){}

    public Node(T data){
        this.data = data;
    }


}
