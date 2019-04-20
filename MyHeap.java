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

    
}