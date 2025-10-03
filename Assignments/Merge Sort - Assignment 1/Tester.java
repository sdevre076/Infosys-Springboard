class Tester {
    // Merge Sort function (sorts elements in-place)
    public static void mergeSort(int[] elements, int size) {
        if (elements == null || size < 2) {
            return;
        }
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        for (int i = 0; i < mid; i++) left[i] = elements[i];
        for (int i = mid; i < size; i++) right[i - mid] = elements[i];
        mergeSort(left, mid);
        mergeSort(right, size - mid);
        merge(elements, left, right, mid, size - mid);
    }
    
    // Merge function
    public static void merge(int[] elements, int[] left, int[] right, int leftMerge, int rightMerge) {
        int i = 0, j = 0, k = 0;
        while (i < leftMerge && j < rightMerge) {
            if (left[i] <= right[j]) elements[k++] = left[i++];
            else elements[k++] = right[j++];
        }
        while (i < leftMerge) elements[k++] = left[i++];
        while (j < rightMerge) elements[k++] = right[j++];
    }
    
    // Find Median - returns double type as required by test
    public static double findMedian(int[] elements) {
        // Return NaN for null, empty, or single-element arrays (displays as "N/A" in tests)
        if (elements == null || elements.length == 0 || elements.length == 1) {
            return Double.NaN;
        }
        
        // Sort the array first (make a copy to avoid modifying original)
        int[] sorted = elements.clone();
        mergeSort(sorted, sorted.length);
        
        int n = sorted.length;
        
        // Calculate median
        if (n % 2 != 0) {
            // Odd number of elements - return middle element
            return sorted[n / 2];
        } else {
            // Even number of elements - return average of two middle elements
            return (sorted[(n / 2) - 1] + sorted[n / 2]) / 2.0;
        }
    }
    
    public static void main(String[] args) {
        int arr1[] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array 1 - Median: " + findMedian(arr1)); // Should be 25.0
        
        int arr2[] = {10, 20, 30, 40};
        System.out.println("Array 2 - Median: " + findMedian(arr2)); // Should be 25.0
        
        int arr3[] = {1, 2, 3, 4, 5};
        System.out.println("Array 3 - Median: " + findMedian(arr3)); // Should be 3.0
        
        int arr4[] = {25, 28, 35, 50, 60, 100};
        System.out.println("Array 4 - Median: " + findMedian(arr4)); // Should be 42.5
        
        int empty[] = {};
        System.out.println("Empty - Median: " + findMedian(empty)); // NaN
        
        int single[] = {42};
        System.out.println("Single - Median: " + findMedian(single)); // 42.0
    }
}