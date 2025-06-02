public class MaxHeapyFiOne {
	
	public static void buildMaxHeapiFy (int[] arr,int p) {
		
		int larget = p;
		int leftChild = 2 * p + 1;
		int rightChild = 2 * p + 2;
		
		if (leftChild < arr.length && arr[leftChild] > arr[larget]) {
			
			larget = leftChild;
			
		} else {
			
			larget = p;
			
		}
		
		if (rightChild < arr.length && arr[rightChild] > arr[larget]) {
			
			larget = rightChild;
			
		}
		
		if (p != larget) {
			
			int temp = arr[p];
			arr[p] = arr[larget];
			arr[larget] = temp;
			buildMaxHeapiFy(arr,larget);
			
		}
		
	}
	
	public static void main (String...args) {
		
		int[] array = {7,24,19,21,14,3,10,2,13,11};
		
		System.out.println ("Array before max heapify : ");
		for (int i = 0; i < array.length; i++) {
			
			System.out.print (array[i]+" ");
			
		}
		
		System.out.println ("\nArray after max heapify : ");
		
		for (int i = array.length /2 - 1; i >= 0; i--) {
			
			buildMaxHeapiFy(array,i);
			
		}
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.print (array[i]+" ");
			
		}
	}
}
		
		