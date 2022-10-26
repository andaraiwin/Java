package DynamicArray;

public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int c_index; // Last element can be indexed at size-1

    public DynamicArray(int cap) { // Class Constructor
        arr = new int[cap];
        capacity = cap;
        c_index = -1;
    }

    public void pushBack(int data) {
        if (c_index >= capacity - 1) { // if exceed limit
            capacity *= 2;
            int[] new_arr = new int[capacity];
            for (int i = 0; i < arr.length; i++) // clone with 2 times size
                new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[++c_index] = data;
    }

    public int popBack() {
        if (c_index < 0) {
            System.out.println("ERROR");
            return 0;
        } else {
            return arr[c_index--];
        }
    }

    public int get(int i) {
        if (i >= c_index) {
            System.out.println("ERROR");
            return 0;
        } else
            return arr[i];
    }

    public void set(int i, int value) {
        if (i >= c_index)
            System.out.println("ERROR");
        else
            arr[i] = value;
    }

    public void remove(int i) {
        if (i > c_index)
            System.out.println("ERROR");
        else {
            while (i < c_index) {
                arr[i] = arr[i + 1];
                i++;
            }
            c_index--;
        }
    }

    public boolean isEmpty() {
        return c_index == -1;
    }

    public int getSize() {
        return c_index + 1;
    }

    public void printStructure() {
        System.out.print("Size = " + (c_index + 1) + ", Cap = " + capacity + ", arr = [");
        for (int i = 0; i <= c_index; i++) {
            System.out.print(" " + arr[i]);
            if (i < c_index)
                System.out.print(",");
        }
        System.out.println(" ]");
    }
}