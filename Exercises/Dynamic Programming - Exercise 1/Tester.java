class Tester {
    
    public static int cutRod(int[] price, int n) {
        // Create a DP array to store maximum revenue for each length
        int[] dp = new int[n + 1];
        
        // Base case: rod of length 0 has 0 revenue
        dp[0] = 0;
        
        // Fill the DP table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            int maxRevenue = 0;
            
            // Try all possible cuts for rod of length i
            for (int j = 1; j <= i; j++) {
                // Cut at position j, so we get:
                // - A piece of length j with price[j-1] (since array is 0-indexed)
                // - Remaining rod of length (i-j) with optimal revenue dp[i-j]
                maxRevenue = Math.max(maxRevenue, price[j - 1] + dp[i - j]);
            }
            
            dp[i] = maxRevenue;
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        // Test case 1
        int price1[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int n1 = 4;
        System.out.println("Maximum price: " + cutRod(price1, n1));
        
        // Test case 2  
        int price2[] = {10, 24, 30, 40, 45};
        int n2 = 5;
        System.out.println("Maximum price: " + cutRod(price2, n2));
        
        // Additional test to show the DP table progression
        System.out.println("\nDP table progression for test case 1:");
        showDPTable(price1, n1);
    }
    
    // Helper method to show DP table for better understanding
    public static void showDPTable(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        System.out.println("Length\tMax Revenue\tOptimal Cuts");
        System.out.println("0\t0\t\t-");
        
        for (int i = 1; i <= n; i++) {
            int maxRevenue = 0;
            int bestCut = 0;
            
            for (int j = 1; j <= i; j++) {
                int currentRevenue = price[j - 1] + dp[i - j];
                if (currentRevenue > maxRevenue) {
                    maxRevenue = currentRevenue;
                    bestCut = j;
                }
            }
            
            dp[i] = maxRevenue;
            System.out.println(i + "\t" + maxRevenue + "\t\tCut: " + bestCut + 
                             " (price=" + price[bestCut-1] + " + remaining=" + dp[i-bestCut] + ")");
        }
    }
}