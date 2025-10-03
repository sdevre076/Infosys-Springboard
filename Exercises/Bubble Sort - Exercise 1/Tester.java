class Tester {
    static int noOfSwaps = 0;
    static int noOfPasses = 0;

    // Swap elements at two positions
    public static void swap(int[] elements, int firstIndex, int secondIndex) {
        int temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }

    // Bubble sort and return number of passes
    public static int bubbleSort(int[] elements) {
        int n = elements.length;
        int passes = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    swap(elements, j, j + 1);
                    swapped = true;
                }
            }

            passes++;
            System.out.print("After pass " + passes + ": ");
            displayArray(elements);

            if (!swapped) break;  // stop early if already sorted
        }
        return passes;
    }

    // Display array elements
    public static void displayArray(int[] elements) {
        for (int element : elements)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] elements = {23, 67, 45, 76, 34, 68, 90};

        System.out.println("Given array:");
        displayArray(elements);

        int noOfPasses = bubbleSort(elements);

        System.out.println("==========================");
        System.out.println("Total number of passes needed to sort the array: " + noOfPasses);
        System.out.println("==========================");

        System.out.println("Array after sorting:");
        displayArray(elements);
    }
}
