package Demo;

public class List {
    Node [] arr;
    int capacity;
    int size;

    public List(int cap){
        capacity = cap;
        arr = new Node[cap];
    }

    public void append(Node node){
        if(size < capacity){
            arr[size] = node;
            size++;
        }
    }

    public void println(){
        System.out.print("[Head] ");
        for (int i = 0; i < size; i++){
            System.out.print(arr[i].key + " ");
        }
        System.out.println("[Tail] ");
    }

    public static void List(string[] args){
        List(6);
        append(2);
        append(4);
        println();
    }
}
