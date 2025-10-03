class Tester {
    
    public static int[][] multiply(int arr1[][], int arr2[][]) {
        // Get dimensions of the matrices
        int rows1 = arr1.length;
        int cols1 = arr1[0].length;
        int rows2 = arr2.length;
        int cols2 = arr2[0].length;
        
        // Check if multiplication is possible
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication not possible - incompatible dimensions");
            return null;
        }
        
        // Create result matrix with dimensions rows1 x cols2
        int[][] result = new int[rows1][cols2];
        
        // Brute force matrix multiplication using three nested loops
        for (int i = 0; i < rows1; i++) {           // For each row in first matrix
            for (int j = 0; j < cols2; j++) {       // For each column in second matrix
                result[i][j] = 0;                   // Initialize result element
                for (int k = 0; k < cols1; k++) {   // Sum of products
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int arr1[][] = {{2,4}, {1,4}};
        int arr2[][] = {{1,4}, {1,3}};
        
        int[][] arr3 = multiply(arr1, arr2);
        
        System.out.println("Test Case 1 Result:");
        for(int index1 = 0; index1 < arr3.length; index1++){
            for(int index2 = 0; index2 < arr3[0].length; index2++){
                System.out.print(arr3[index1][index2] + " ");
            }
            System.out.println();
        }
        
        // Test case 2
        int arr4[][] = {{2,2}, {2,2}};
        int arr5[][] = {{4,4}, {4,4}};
        
        int[][] arr6 = multiply(arr4, arr5);
        
        System.out.println("\nTest Case 2 Result:");
        for(int index1 = 0; index1 < arr6.length; index1++){
            for(int index2 = 0; index2 < arr6[0].length; index2++){
                System.out.print(arr6[index1][index2] + " ");
            }
            System.out.println();
        }
        
        // Additional test case with different dimensions
        System.out.println("\nAdditional Test - 2x3 * 3x2 matrix:");
        int arr7[][] = {{1, 2, 3}, {4, 5, 6}};
        int arr8[][] = {{7, 8}, {9, 10}, {11, 12}};
        
        int[][] arr9 = multiply(arr7, arr8);
        
        if (arr9 != null) {
            for(int index1 = 0; index1 < arr9.length; index1++){
                for(int index2 = 0; index2 < arr9[0].length; index2++){
                    System.out.print(arr9[index1][index2] + " ");
                }
                System.out.println();
            }
        }
    }
}