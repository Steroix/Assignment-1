//------------------------------------------------------------
// Title: Node Class
//Author: R. Pelin Güryuva
//ID: 43081043542
//Section: 1
//Assignment: 1
//Description: This class is a node class that is used in DoublyLinkedList class to create a doubly linked listi
//It has three fields, element, prev and next. Element is the data that is stored in the node. Prev is the previous node of the node and next is the next node of the node.
//It has three constructors. One of them is empty constructor, one of them is a constructor that creates a new node with the given item and null links to previous and next and the other one is a constructor that creats a new node with given fields. 
//----------------------------------------------------------------------------------------------

public class Node<Item> {
    protected Item element;
    protected Node<Item> prev, next;

    // Empty constructor
    public Node() {
   
    }
    // Constructor that creates a new node with the given item and null links to
    // previous and next

    public Node(Item element) {
        //Constructor that creates a new node with element
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public Node(Item element, Node<Item> prev, Node<Item> next) {
        // Construtor that creats a new node with given fields (data, previous, next)
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public Item getElement() {
        // Returns the element of this node
        return element;
    }

    public Node<Item> getPrev() {
        // Returns the previous node of this node
        return this.prev;
    }

    public Node<Item> getNext() {
       // returns the next node of this node
        return this.next;
    }

    public void setData(Item newElement) {
        // Sets the element of this node
        element = newElement;
    }

    public void setNext(Node<Item> next) {
        // Sets the next node of this node
        this.next = next;
    }

    public void setPrev(Node<Item> prev) {
        // Sets the previous node of this node
        this.prev = prev;
    }
}