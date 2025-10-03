class Tester {

    public static int findSwapCount(String inputString) {
        int swaps = 0;
        int imbalance = 0;
        int openCount = 0;
        int closeCount = 0;

        for (char ch : inputString.toCharArray()) {
            if (ch == '(') {
                openCount++;
                if (imbalance > 0) {
                    swaps += imbalance;
                    imbalance--;
                }
            } else {
                closeCount++;
                imbalance = closeCount - openCount;
            }
        }
        return swaps;
    }

    public static void main(String args[]) {
        String inputString1 = "())()(";
        String inputString2 = "()";
        String inputString3 = "())((";

        System.out.println("Number of swaps for '" + inputString1 + "': " + findSwapCount(inputString1));
        System.out.println("Number of swaps for '" + inputString2 + "': " + findSwapCount(inputString2));
        System.out.println("Number of swaps for '" + inputString3 + "': " + findSwapCount(inputString3));
    }
}
