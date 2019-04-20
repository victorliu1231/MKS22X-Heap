import java.util.Arrays;

public class MyHeap{
    private static void pushDown(int[]data, int size, int index){
        int l = 2*index+1;
        int r = 2*index+2;
        int parent = data[index];
        if (l >= size){ //if no children
            return;
        } else if (r >= size){ //if only one child
            if (parent >= data[l]){
                return;
            } else {
                swap(data, index, l);
            }
        } else if (parent < data[l] && parent < data[r]){
            if (data[l] > data[r]){
                swap(data, index, l);
                pushDown(data, size, l);
            } else {
                swap(data, index, r);
                pushDown(data,size,r);
            }
        } else if (parent < data[l]){
            swap(data, index, l);
            pushDown(data,size,l);
        } else if (parent < data[r]){
            swap(data, index, r);
            pushDown(data,size,r);
        } else {
            return;
        }
    }

    private static void pushUp(int[]data, int index){
        int parent = (index-1)/2;
        if (data[index] > data[parent]){
            swap(data,index,parent);
            pushUp(data,parent);
        }
    }
    // - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
    // - precondition: index is between 0 and data.length-1 inclusive.

    public static void heapify(int[] data){
        int endOfPenultimateRow = calculate(data.length) - 1;
        for (int i = endOfPenultimateRow; i >= 0; i--){
            pushDown(data, data.length, i);
        }
    }
    //- convert the array into a valid heap. [ should be O(n) ]

    public static void heapsort(int[] data){
        heapify(data);
        for (int i = data.length-1; i > 0; i--){
            swap(data, 0, i);
            pushDown(data, i, 0);
        }
    }
    //- sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]

    private static void swap(int[] data, int a, int b){
        int storer = data[a];
        data[a] = data[b];
        data[b] = storer;
    }

    private static int calculate(int length){
        int n = 0;
        while (Math.pow(2,n) - 1 <= length){
            n++;
        }
        return (int)(Math.pow(2,n-1) - 1);
    }
}