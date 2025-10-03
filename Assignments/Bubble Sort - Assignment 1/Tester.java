class Tester {

    // Bubble Sort
    public static void sortArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Find maximum sum of 'm' largest elements
    public static int findMaxSum(int arr[], int m) {
        if (m > arr.length) return 0;
        int sum = 0;
        for (int i = arr.length - m; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Find minimum sum of 'm' smallest elements
    public static int findMinSum(int arr[], int m) {
        if (m > arr.length) return 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        sortArray(arr);
        
        System.out.println("Maximum Sum for m=4: " + findMaxSum(arr, 4)); // Expected: 213
        System.out.println("Minimum Sum for m=3: " + findMinSum(arr, 3)); // Expected: 45
    }
}
