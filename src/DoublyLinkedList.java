// --------------------------------------------------------------------------------------------------------------------------------------
// Title: Doubly Linked List Class
// Author: R.Pelin Güryuva  
// ID: 4308104342
// Section: 1
// Assignment: 1
//--------------------------------------------------------------------------------------------------------------------------------------
// Description: This class is a doubly linked list class that is used to create a doubly linked list.
// It has two fields, head and tail. 
// Head is the first node of the list and tail is the last node of the list. 
//--------------------------------------------------------------------------------------------------------------------------------------
public class DoublyLinkedList<Item> {
    Node<Item> head, tail;
    private int size;

    DoublyLinkedList() {
        // Generated an empty Doubly linked list constructor
        head = new Node<Item>(null, null, null);
        tail = new Node<Item>(null, head, null); 
    }

    public void addFirst(Item item) {
        // Genereted a method that adds item to the list from the top
        Node<Item> n = new Node<Item>(item, null, head);
        if (head != null) {
            head.setPrev(n);
            head = n;
        }
        if (size() == 0) {
            // if the list is null then it sets the node as a head and tail. 
            tail = head = n;
        }

    }

    public void add(Item item) {
        //This method adds an item to the list from the end.
        Node<Item> newNode = new Node<Item>(item, null, null);

        if (size() > 0 && tail != null) {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            // if the list is null then it sets the node as a head and tail.
            addFirst(item);
        }
        size++;
    }

    public Node<Item> add(Item item, int index) {
        //This method adds an item to the list at the given index.
        if (index >= size() || index < 0) {
            // if the index is out of bounds then it throws an exception.
            throw new IndexOutOfBoundsException("Position " + index + "does not exists");
        }
        Node<Item> nodeNew = null;
        if (item != null) {
            Node<Item> node = head;
            if (node.next != null) {
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
            }
            nodeNew = new Node<Item>(item, node, node.next);

            if (node.next != null) {
                node.next.prev = nodeNew;
            }
            node.next = nodeNew;
        }
        return nodeNew;
    }

    public Node<Item> deleteFirst() {
        //This method deletes the first node of the list.
        Node<Item> temp = getNode(0);
        if (temp != null && temp.next != null) {
            temp.next.prev = head;
            head.next = temp.next;
            size--;
        } else {
            head.next = null;
        }
        return temp;
    }

    public Node<Item> delete() {
        //This method deletes the last node of the list.
        Node<Item> temp = getNode(size() - 1);
        if (temp != null && temp.getPrev() != null) {
            temp.getPrev().setNext(null);
            tail = temp.getPrev();
            size--;
        } else {
            head = null;
            tail = null;
        }
        return temp;
    }

    Node<Item> getNode(int index) {
        //This method returns the node at the given index.
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<Item> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public String get(int index) {
        //This method returns the item at the given index.
        Node<Item> node = getNode(index);
        // if the node is not null then it returns the element of the node.
        return (node != null) ? node.element.toString() : null;
    }

    public int find(Item item) {
        //This method returns the index of the given item.
        if (item == null) {
            // if the item is null then it returns -1.
            return -1;
        }
        if (head == null) {
            // if the head is null then it returns -1.
            return -1;
        }
        Node<Item> currNode = head;
        for (int i = 0; currNode.next != null; i++) {
            // if the item is equal to the element of the node then it returns the index.
            currNode = currNode.next;
            if (item.equals(currNode.element)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        //This method returns the size of the list.
        return size;
    }

    public boolean isEmpty() {
        //This method returns whether the list is empty or not.
        boolean isEmpty = (size() > 0) ? false : true;
        return isEmpty;
    }

    public String toString() {
        //This method returns the string representation of the list.
        StringBuilder sb = new StringBuilder("[ ");
        Node<Item> next = head;
        while (next != null) {
            // if the next node is not null then it appends the element of the node to the string builder.
            sb.append(next.getElement() + " , ");
            next = next.getNext();
        }
        String ret = sb.toString();
        if (ret.length() > 1) {
            // if the length of the string is greater than 1 then it removes the last two characters.
            ret = ret.substring(0, ret.length() - 2);
        }
        return (ret + "]");
    }
    
    public Node<Item> deleteAt(int index) {
        //This method deletes the node at the given index.
        if (index < 0 || index >= size()) {
            // if the index is out of bounds then it throws an exception.
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<Item> deletedNode;
        if (index == 0) {
            // if the index is 0 then it deletes the first node.
            deletedNode = deleteFirst();
        } else if (index == size() - 1) {
           // if the index is the last index then it deletes the last node.
            deletedNode = delete();
        } else {
            // if the index is not the first or the last index then it deletes the node at the given index.
            Node<Item> prev = getNode(index - 1);
            deletedNode = prev.getNext();
            prev.setNext(deletedNode.getNext());
            deletedNode.getNext().setPrev(prev);
            size--;
        }

        return deletedNode;
    }

}