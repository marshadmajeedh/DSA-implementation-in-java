package build;

import static heapify.Heapify.heapify;

public class BuildMaxHeapify {

    public static void buildMaxHeap(int[] arr) {

        int n = arr.length;

        for (int i = n/ 2 -1; i >= 0; i-- ) {

            heapify(arr,i,n);
        }
    }
}
