class Tester {
    
    public static int findMaxSum(int arr[], int low, int high) {
        // Base case: only one element
        if (low == high) {
            return arr[low];
        }
        
        // Find middle point
        int mid = (low + high) / 2;
        
        // Recursively find maximum sum in left and right halves
        int leftMaxSum = findMaxSum(arr, low, mid);
        int rightMaxSum = findMaxSum(arr, mid + 1, high);
        
        // Find maximum sum of subarray crossing the middle
        int crossingMaxSum = findMaxCrossingSubarraySum(arr, low, mid, high);
        
        // Return maximum of the three
        return Math.max(Math.max(leftMaxSum, rightMaxSum), crossingMaxSum);
    }
    
    public static int findMaxCrossingSubarraySum(int arr[], int low, int mid, int high) {
        // Find maximum sum for left side (including mid element)
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        
        // Traverse from mid to low
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        
        // Find maximum sum for right side (excluding mid element)
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        
        // Traverse from mid+1 to high
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        
        // Return sum of maximum left and right sums
        return leftSum + rightSum;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int arr1[] = {-2, -5, 6, -2, -3, 1, 5, -6};
        System.out.println("Maximum sum: " + findMaxSum(arr1, 0, arr1.length - 1));
        
        // Test case 2
        int arr2[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum: " + findMaxSum(arr2, 0, arr2.length - 1));
        
        // Additional test cases
        System.out.println("\nAdditional Test Cases:");
        
        // All negative numbers
        int arr3[] = {-5, -2, -8, -1};
        System.out.println("All negative: " + findMaxSum(arr3, 0, arr3.length - 1));
        
        // All positive numbers
        int arr4[] = {1, 2, 3, 4, 5};
        System.out.println("All positive: " + findMaxSum(arr4, 0, arr4.length - 1));
        
        // Single element
        int arr5[] = {42};
        System.out.println("Single element: " + findMaxSum(arr5, 0, arr5.length - 1));
        
        // Show step-by-step for better understanding
        System.out.println("\nStep-by-step analysis for test case 1:");
        analyzeMaxSubarray(arr1);
    }
    
    // Helper method to show the actual subarray that gives maximum sum
    public static void analyzeMaxSubarray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0, tempStart = 0;
        int currentSum = 0;
        
        // Using Kadane's algorithm to find the actual subarray
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
            
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        
        System.out.print("Maximum subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("] with sum = " + maxSum);
        System.out.println("Indices: " + start + " to " + end);
    }
}