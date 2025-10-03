import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

class Tester {
    
    public static List<Integer> findCommonElements(List<Integer> listOne, List<Integer> listTwo){
        List<Integer> commonElements = new LinkedList<Integer>();
        
        // Use HashSet for O(1) lookups to check if element exists in listTwo
        HashSet<Integer> setTwo = new HashSet<Integer>(listTwo);
        
        // Iterate through listOne and check if each element exists in listTwo
        for (Integer num : listOne) {
            if (setTwo.contains(num)) {
                commonElements.add(num);
            }
        }
        
        return commonElements;
    }
    
    public static void main(String arga[]){

        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(12);
        listOne.add(21);
        listOne.add(1);
        listOne.add(53);
        
        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(11);
        listTwo.add(21);
        listTwo.add(25);
        listTwo.add(53);
        listTwo.add(47);

        System.out.println(findCommonElements(listOne, listTwo));
        
        // Test with the second sample case
        List<Integer> listThree = new LinkedList<Integer>();
        listThree.add(51);
        listThree.add(45);
        listThree.add(63);
        listThree.add(15);
        listThree.add(82);
        
        List<Integer> listFour = new LinkedList<Integer>();
        listFour.add(19);
        listFour.add(63);
        listFour.add(51);
        listFour.add(87);
        listFour.add(82);

        System.out.println(findCommonElements(listThree, listFour));
    }
}