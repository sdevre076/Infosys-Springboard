class Tester {
    
    public static int calculatePower(int num, int p) {
        // Special cases
        if (num == 0 && p > 0) {
            return 0;  // e.g., 0^10 = 0
        }
        if (p == 0) {
            return 1;  // any number^0 = 1
        }

        int result = 1;
        for (int i = 1; i <= p; i++) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2, 3));   // Expected: 8
        System.out.println(calculatePower(0, 10));  // Expected: 0
    }
}
