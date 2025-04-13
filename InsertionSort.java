public class InsertionSort {
    public static void main(String... args) {

        int[] array = {1, 3, 5, 2, 4};

        for (int i = 1; i < array.length; i++) {

            int key = array[i];

            int j = i - 1;

            while (j >= 0 && array[j] > key) {

                array[j + 1] = array[j];
                j = j - 1;

            }

            array[j + 1] = key;

        }

        for (int a : array) {

            System.out.print(a + " ");

        }
    }
}