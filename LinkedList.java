// linkedlist/LinkedList.java

package linkedlist;
import Node.java;

public class LinkedList {
    Node head;

    void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void findKthToLast(int k) {
        // ... (use the optimized findKthToLast method from previous response)
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original Linked List:");
        list.printList();

        int k = 2; // Change k as needed
        list.findKthToLast(k);
    }
}
