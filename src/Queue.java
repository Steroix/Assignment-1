//----------------------------------------------------------------------------------------------------------------------------
// Title: Queue Class
// Author: R. Pelin Güryuva
// ID: 43081043542
// Section: 1
// Assignment: 1
//---------------------------------------------------------------------------------------------------------------------------
// Description: This class is a queue class that is used to create a queue. 
// It has two fields, first and last. First is the first node of the queue and last is the last node of the queue.
//---------------------------------------------------------------------------------------------------------------------------

public class Queue<Item> {
    Node<Item> first, last;
    private int size;

    public Queue() {
        // Constructor that creates an empty queue
        first = null;
        last = null;
        size = 0;
    }

    public boolean isQueueEmpty() {
        // Returns whether the queue is empty or not
        return first == null;
    }

    public void enqueue(Item item) {
        // Adds an item to the queue
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.element = item;
        last.next = null;
        if (isQueueEmpty()) {
            // if the queue is empty then it sets the first node as the last node
            first = last;
            size++;
        } else {
            // if the queue is not empty then it sets the next node of the old last node as the last node
            oldLast.next = last;
            size++;
        }
    }

    public Item dequeue() {
        // Removes the first item of the queue
        Item item = first.element;
        first = first.next;
        if (isQueueEmpty()) {
            // if the queue is empty then it sets the last node as null
            last = null; // Update last when the queue becomes empty
        }
        // Decrease the size of the queue
        size--;
        return item;
    }

    public int size() {
        // Returns the size of the queue
        return size;
    }
    public void printQueue(){
        // Prints the elements of the queue
        DoublyLinkedList<Item> list = new DoublyLinkedList<>();
        //if the queue is empty then it prints "Queue is empty"
        if (isQueueEmpty()) {
            System.out.println("Queue is empty");
            return;
        }else{
            while(!isQueueEmpty()){
               Item item=dequeue();
                list.add(item);
                }
            for (int i = 0; i < list.size(); i++) {
                Node<Item> node = list.getNode(i);
                System.out.println(node.getElement());
            }
            for (int i = 0; i < list.size(); i++) {
                Node<Item> node = list.getNode(i);
                enqueue(node.getElement());
            }
        }
        
    
    }
}