class Tester {
    
    public static int findMaxActivities(int start[], int finish[]) {
        int n = start.length;
        
        // The first activity is always selected
        int count = 1;
        int lastSelected = 0;  // Index of the last selected activity
        
        // Consider remaining activities starting from index 1
        for (int i = 1; i < n; i++) {
            // If the start time of current activity is greater than or equal to
            // the finish time of the last selected activity, then select it
            if (start[i] >= finish[lastSelected]) {
                count++;
                lastSelected = i;  // Update the last selected activity
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int start1[] = {1, 3, 0, 5, 8, 5};
        int finish1[] = {2, 4, 6, 7, 9, 9};
        
        System.out.println("Maximum number of activities: " + findMaxActivities(start1, finish1));
        
        // Test case 2
        int start2[] = {1, 3, 0, 5, 9, 8};
        int finish2[] = {3, 5, 8, 10, 12, 13};
        
        System.out.println("Maximum number of activities: " + findMaxActivities(start2, finish2));
        
        // Additional test to show which activities are selected
        System.out.println("\nDetailed solution for test case 1:");
        printSelectedActivities(start1, finish1);
    }
    
    // Helper method to show which activities are selected (for better understanding)
    public static void printSelectedActivities(int start[], int finish[]) {
        int n = start.length;
        
        System.out.println("Selected activities (index, start, finish):");
        System.out.println("Activity 0: (" + start[0] + ", " + finish[0] + ")");
        
        int lastSelected = 0;
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (start[i] >= finish[lastSelected]) {
                System.out.println("Activity " + i + ": (" + start[i] + ", " + finish[i] + ")");
                lastSelected = i;
                count++;
            }
        }
        
        System.out.println("Total activities selected: " + count);
    }
}