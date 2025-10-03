import java.util.ArrayDeque;
import java.util.Deque;

class Tester {

    public static Deque<Character> updateStack(Deque<Character> inputStack) {
        Deque<Character> tempStack = new ArrayDeque<>();
        Deque<Character> resultStack = new ArrayDeque<>();

        // Step 1: Reverse inputStack into tempStack to access bottom elements
        while (!inputStack.isEmpty()) {
            tempStack.push(inputStack.pop());
        }

        // Step 2: Extract bottom 3 elements (which are now on top of tempStack)
        Deque<Character> bottomThree = new ArrayDeque<>();
        int count = 0;
        while (!tempStack.isEmpty()) {
            Character ch = tempStack.pop();
            if (count < 3) {
                bottomThree.addLast(ch); // maintain original order
            } else {
                resultStack.push(ch);
            }
            count++;
        }

        // Step 3: Push the bottom three elements on top of resultStack
        for (Character ch : bottomThree) {
            resultStack.push(ch);
        }

        return resultStack;
    }
    
    public static void main(String[] args) {
        
        Deque<Character> inputStack = new ArrayDeque<Character>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');
        
        Deque<Character> resultStack = updateStack(inputStack);
        
        System.out.println("The alphabets in updated stack are:");
        for(Character alphabet: resultStack)
            System.out.println(alphabet);
    }
}
