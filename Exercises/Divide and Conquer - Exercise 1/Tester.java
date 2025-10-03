class Tester {
    
    public static int[] getMaxMin(int arr[], int low, int high) {
        // Base case: only one element
        if (low == high) {
            return new int[]{arr[low], arr[low]};
        }
        
        // Base case: two elements
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                return new int[]{arr[low], arr[high]};
            } else {
                return new int[]{arr[high], arr[low]};
            }
        }
        
        // Divide: find middle point
        int mid = (low + high) / 2;
        
        // Conquer: recursively find max and min in both halves
        int[] leftResult = getMaxMin(arr, low, mid);
        int[] rightResult = getMaxMin(arr, mid + 1, high);
        
        // Combine: compare results from both halves
        int maxOverall = Math.max(leftResult[0], rightResult[0]);
        int minOverall = Math.min(leftResult[1], rightResult[1]);
        
        return new int[]{maxOverall, minOverall};
    }
    
    public static void main(String args[]) {
        int arr[] = {1000, 10, 5, 1, 2000};
        
        int[] maxMin = getMaxMin(arr, 0, arr.length - 1);
        
        System.out.println("Maximum value is "+ maxMin[0]);
        System.out.println("Minimum value is "+ maxMin[1]);
        
        // Test with second example
        int arr2[] = {2, 3};
        int[] maxMin2 = getMaxMin(arr2, 0, arr2.length - 1);
        
        System.out.println("\nSecond test:");
        System.out.println("Maximum value is "+ maxMin2[0]);
        System.out.println("Minimum value is "+ maxMin2[1]);
    }
}