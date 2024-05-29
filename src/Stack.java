//---------------------------------------------------------------------------------------------------------------------------
// Title: Stack Class
// Author: R. Pelin Güryuva
// ID: 43081043542
// Section: 1
// Assignment: 1
//---------------------------------------------------------------------------------------------------------------------------
// Description: This class is a stack class that is used to create a stack.
// It has two fields, end and top. End is the last node of the stack and top is the first node of the stack.
//---------------------------------------------------------------------------------------------------------------------------


public class Stack<Item> {
    Node<Item> end = null;
    Node<Item> top = null;
    private int size = 0;

    public Stack() {
        // Constructor that creates an empty stack
        end = null;
        top = null;
    }


    public boolean isEmpty() {
        // Returns whether the stack is empty or not
        return end == null;
    }

    public Item push(Item data) {
        // Adds an item to the stack
        Node<Item> newNode = new Node<Item>(data, null, null);
        if (isEmpty()) {
            // if the stack is empty then it sets the new node as the top and end node
            top = end = newNode;
            size++;
        } else {
            // if the stack is not empty then it sets the next node of the end node as the new node and sets the new node as the end node
            end.setPrev(newNode);
            newNode.setNext(end);
            end = newNode;
        }
        size++;
        return data;
    }

    public Item pop() {
        // Removes the last item of the stack
        if (isEmpty()) {
            // if the stack is empty then it throws an exception
            throw new IllegalStateException("Stack is empty");
        } else if (top == end) {
            // if the stack has only one element then it sets the top and end node as null
            Item item = top.getElement(); // Store the last element
            top = null;
            end = null;
            size--;
            return item; // Return the last element
        } else {
            // if the stack has more than one element then it sets the next node of the end node as the end node and
            // sets the previous node of the new end node as null
            Item item = end.getElement(); // Store the element of the current end node
            Node<Item> prevNode = end.getNext();
            prevNode.setPrev(null);
            end = prevNode;
            size--;
            return item; // Return the element of the original end node
        }
    }

    public Item topElement() {
        // Returns the last item of the stack
        if (isEmpty()) {
            // if the stack is empty then it throws an exception
            throw new IllegalStateException("Stack is empty");
        } else {
            // if the stack is not empty then it returns the element of the end node
            System.out.println("The element at top of the stack is : " + end.getElement());
        }
        return top.getElement();
    }

    public int stackSize() {
        // Returns the size of the stack
       return size;
    }

    public void printStack() {
        // Prints the stack
        if (isEmpty()) {
            // if the stack is empty then it prints that the stack is empty
            System.out.println("Stack is empty");
        } else {
            // if the stack is not empty then it prints the elements of the stack
          DoublyLinkedList<Item> list = new DoublyLinkedList<Item>();
          // Create a list to store the elements of the stack
          while(!isEmpty()) {
            // While the stack is not empty, pop the elements and add them to the list
              Item item = pop();
              list.add(item);
            }
            for (int i = 0; i < list.size(); i++) {
                // Print the elements of the list
                Node<Item> node = list.getNode(i);
                System.out.println(node.getElement());
            }
            for(int i=0; i<list.size(); i++) {
                // Push the elements back to the stack
                push(list.getNode(list.size()-1-i).getElement());
            }

        }
    }
}