import static print.PrintArray.printArray;
import static sort.HeapSort.heapSort;

public class HeapMain {
    public static void main(String[] args) {

        int [] arr = {4,1,3,2,16,9,10,14,8,7};

        System.out.println("Array before heap sort : ");
        printArray(arr);

        System.out.println("\nArray after heap sort : ");
        heapSort(arr);

        printArray(arr);
    }
}
