public class QueueUsingLinkedList {
    // Inner Node class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    // Constructor
    public QueueUsingLinkedList() {
        front = rear = null;
    }

    // Enqueue operation (insert at rear)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) { // queue empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue operation (remove from front)
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        front = front.next;
        if (front == null) { // queue became empty
            rear = null;
        }
    }

    // Peek operation (see front element)
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Display elements
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display(); // Output: 10 20 30 40

        q.dequeue();
        q.display(); // Output: 20 30 40

        System.out.println("Front element: " + q.peek()); // Output: 20
    }
}
