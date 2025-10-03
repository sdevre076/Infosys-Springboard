import java.util.LinkedList;
import java.util.List;

public class Tester {
    
    public static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> merged = new LinkedList<>();
        int i = 0, j = 0;
        
        // Merge like in “merge” step of merge-sort
        while (i < listOne.size() && j < listTwo.size()) {
            if (listOne.get(i) <= listTwo.get(j)) {
                merged.add(listOne.get(i));
                i++;
            } else {
                merged.add(listTwo.get(j));
                j++;
            }
        }
        
        // Add remaining elements from listOne
        while (i < listOne.size()) {
            merged.add(listOne.get(i));
            i++;
        }
        
        // Add remaining elements from listTwo
        while (j < listTwo.size()) {
            merged.add(listTwo.get(j));
            j++;
        }
        
        return merged;
    }

    public static void main(String[] args) {
        List<Integer> listOne = new LinkedList<>();
        listOne.add(10);
        listOne.add(13);
        listOne.add(21);
        listOne.add(42);
        listOne.add(56);
        
        List<Integer> listTwo = new LinkedList<>();
        listTwo.add(15);
        listTwo.add(20);
        listTwo.add(21);
        listTwo.add(85);
        listTwo.add(92);
        
        List<Integer> mergedList = mergeLists(listOne, listTwo);
        System.out.println(mergedList);
    }
}
