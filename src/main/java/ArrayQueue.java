public class ArrayQueue {

    private int[] queue;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
    }

    void enqueue(int value) {
        if (isFull()) queue = reallocate(capacity * 2);
        queue[rear++] = value;
        size++;
    }

    int dequeue() {
        if (isEmpty()) return -1;
        size--;

        return queue[front++];
    }

    int peek() {
        return queue[front];
    }

    int[] reallocate(int newCapacity) {
        int[] newQueue = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }
        capacity = newCapacity;

        return newQueue;
    }

    int size() {
        return size;
    }
    int length() { return queue.length; }
    int capacity() { return capacity; }
    boolean isFull() { return capacity == size; }
    boolean isEmpty() { return size == 0; }
}
