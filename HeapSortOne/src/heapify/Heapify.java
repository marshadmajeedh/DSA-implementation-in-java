package heapify;

public class Heapify {

    public static void heapify(int[] array, int l,int heapSize) {

        int largest = l;
        int leftChild = 2 * l + 1;
        int rightChild = 2 * l + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]) {

            largest = leftChild;
        }
        else {
            largest = l;
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {

            largest = rightChild;
        }

        if (largest != l) {

            int temp = array[largest];
            array[largest] = array[l];
            array[l] = temp;
            heapify(array, largest,heapSize);
        }
    }
}
