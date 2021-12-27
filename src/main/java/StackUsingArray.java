public class StackUsingArray {

    private int[] arr;
    private int top;
    private int capacity;

    public StackUsingArray(int capacity) {
        this.arr = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    public int getTop() {
        return arr[top];
    }

    public int getCapacity() {
        return capacity;
    }

    private boolean isFull() {
        return top+1 == capacity;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private int[] reallocate(int newCapacity) {
        int[] newArr = new int[newCapacity];

        for(int i=0; i< capacity; ++i)
            newArr[i] = arr[i];

        capacity = newCapacity;
        return newArr;
    }

    public void push(int value) {
        if(isFull()) arr = reallocate(capacity * 2);
        arr[++top] = value;
    }

    public int pop() {
        if(isEmpty()) return -1;
        return arr[top--];
    }

    public int search(int value) {
        for(int i = top; i > -1; --i) {
            if(arr[i] == value) return arr[i];
        }
        return -1;
    }

    public int indexOf(int value) {
        for(int i = top; i > -1; --i) {
            if(arr[i] == value) return i;
        }
        return -1;
    }
}