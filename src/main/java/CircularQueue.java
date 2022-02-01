public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        queue = new int[capacity];
    }

    public int peek() { return queue[front+1]; }

    public void enqueue(int value) {
        if (isFull()) return;

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;

        front = (front + 1) % queue.length;
        size--;

        return queue[front];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return queue.length;
    }

    public boolean isFull() {
        return front == (rear + 1) % queue.length;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
