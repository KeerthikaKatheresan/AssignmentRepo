public class CircularQueue {
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
    public CircularQueue() {
        front = rear = null;
    }

    // Enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
            rear.next = front; // circular link
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // maintain circularity
        }
    }

    // Dequeue operation
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        if (front == rear) { // only one node
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front; // maintain circularity
        }
    }

    // Display elements
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);

        cq.display(); // Output: 10 20 30 40

        cq.dequeue();
        cq.display(); // Output: 20 30 40

        cq.enqueue(50);
        cq.display(); // Output: 20 30 40 50
    }
}
