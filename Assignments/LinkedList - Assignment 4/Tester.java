import java.util.LinkedList;

class Queue {
    private LinkedList<String> queue;
    private int maxSize;
    
    // Constructor
    public Queue(int maxSize) {
        this.queue = new LinkedList<String>();
        this.maxSize = maxSize;
    }
    
    // Returns the entire queue
    public LinkedList<String> getQueue() {
        return queue;
    }
    
    // Checks if queue is full
    public boolean isFull() {
        return queue.size() >= maxSize;
    }
    
    // Checks if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    // Adds an element to the end of the queue
    public boolean enqueue(String data) {
        if (isFull()) {
            return false; // Cannot add if queue is full
        }
        queue.addLast(data);
        return true;
    }
    
    // Removes an element from the front of the queue
    public boolean dequeue() {
        if (isEmpty()) {
            return false; // Cannot remove if queue is empty
        }
        queue.removeFirst();
        return true;
    }
}

class Tester {

    public static void main(String arga[]){
        Queue queue = new Queue(5);
        
        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");
        
        queue.dequeue();
        queue.dequeue();
    
        System.out.println(queue.getQueue());
    }
}