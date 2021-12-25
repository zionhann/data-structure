public class DynamicArray {

    private int[] arr;
    private int size;           // 배열에 포함된 원소의 개수
    private int capacity;       // 배열의 크기

    public DynamicArray(int initialCapacity) {
        capacity = initialCapacity;
        size = 0;
        arr = new int[capacity];
    }

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    //Appending
    public void push_back(int i) {
        if(isFull()) arr = reallocate(capacity * 2);
        arr[size++] = i;
    }

    private boolean isFull() {
        return capacity == size;
    }


    private int[] reallocate(int capacity) {
        int[] newArr = new int[capacity];

        for(int i=0; i< size; i++) {
            newArr[i] = arr[i];
        }
        this.capacity = capacity;
        return  newArr;
    }

    //Access
    public int getValue(int idx) {
        return arr[idx];
    }

    //Access
    public void setValue(int idx, int value) {
        arr[idx] = value;
    }

    //Search
    public int search(int target) {
        int idx = -1;

        for(int i=0; i< capacity; i++) {
            if(arr[i] == target) idx = i;
        }
        return idx;
    }
}