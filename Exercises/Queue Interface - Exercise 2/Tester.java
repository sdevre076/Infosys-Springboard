import java.util.Deque;
import java.util.ArrayDeque;

class Tester {
    
    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        Deque<Integer> tempStack = new ArrayDeque<>();
        Deque<Integer> resultStack = new ArrayDeque<>();
        
        // Step 1: Find the smallest element and count its occurrences
        int smallest = Integer.MAX_VALUE;
        int count = 0;
        
        // Move all elements to tempStack while finding the smallest and counting occurrences
        while (!inputStack.isEmpty()) {
            int element = inputStack.pop();
            if (element < smallest) {
                smallest = element;
                count = 1;
            } else if (element == smallest) {
                count++;
            }
            tempStack.push(element);
        }
        
        // Step 2: Move elements back to resultStack excluding the smallest elements
        while (!tempStack.isEmpty()) {
            int element = tempStack.pop();
            if (element != smallest) {
                resultStack.push(element);
            }
        }
        
        // Step 3: Add the smallest elements at the bottom of the resultStack
        // First, move elements to tempStack to reverse again
        while (!resultStack.isEmpty()) {
            tempStack.push(resultStack.pop());
        }
        
        // Add the smallest elements
        for (int i = 0; i < count; i++) {
            resultStack.push(smallest);
        }
        
        // Restore the order of other elements
        while (!tempStack.isEmpty()) {
            resultStack.push(tempStack.pop());
        }
        
        return resultStack;
    }

    public static void main(String[] args) {
        
        Deque<Integer> inputStack = new ArrayDeque<Integer>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);
    
        Deque<Integer> updatedStack = changeSmallest(inputStack);
        
        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}
