package sort;

import static build.BuildMaxHeapify.buildMaxHeap;
import static heapify.Heapify.heapify;

public class HeapSort {

    public static void heapSort(int[] arr) {

        buildMaxHeap(arr);

        for (int i = arr.length - 1; i >= 1; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,0,i);
        }
    }
}
