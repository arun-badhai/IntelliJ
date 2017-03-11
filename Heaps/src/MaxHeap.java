/**
 * Created by Shivani Shinde on 11-03-2017.
 */
class MaxHeap {
    static int pointer = 0;
    static int[] array = new int[100];

    public  static void swap(int child, int parent){
        int temp = array[child];
        array[child] = array[parent];
        array[parent] = temp;
    }

    public static void heapifyleft(int child, int parent){
        if(parent >= 0 && array[parent] < array[child]){
            swap(child,parent);
            if(parent%2 == 0){
                child = parent;
                parent = parent/2 - 1;
                heapifyright(child, parent);
            }
            else{
                child = parent;
                parent = parent/2;
                heapifyleft(child, parent);
            }
        }
    }

    public static void heapifyright(int child, int parent){
        if(parent >= 0 && array[parent] < array[child]){
            swap(child,parent);
            if(parent%2 == 0){
                child = parent;
                parent = parent/2 - 1;
                heapifyright(child, parent);
            }
            else{
                child = parent;
                parent = parent/2;
                heapifyleft(child, parent);
            }
        }
    }

    public static void insert(int value){
        if(array[pointer] == 0){
            array[pointer] = value;
        }
        else{
            if(array[pointer*2 + 1] == 0){
                int temp = pointer*2 + 1;
                array[temp] = value;
                heapifyleft(temp, pointer);
            }
            else{
                int temp = pointer*2 + 2;
                array[temp] = value;
                heapifyleft(temp, pointer);
                pointer++;
            }
        }
    }
    public static void main (String[] args) throws java.lang.Exception {

        insert(5); insert(7); insert(6);
        insert(2); insert(3); insert(4);
        insert(5); insert(8); insert(6);

        System.out.println("Max Heap: ");
        for(int i=0;i<array.length;i++){
            if(array[i] != 0){
                System.out.print(array[i]+ " ");
            }
        }
    }
}
