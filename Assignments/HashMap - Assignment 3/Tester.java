import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
	
class Tester {
    public static Map<Character, Integer> findOccurrences(String input) {
        // Create a LinkedHashMap to store character occurrences in insertion order
        Map<Character, Integer> occurrenceMap = new LinkedHashMap<>();
        
        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // Skip spaces - don't count them
            if (currentChar == ' ') {
                continue;
            }
            
            // If character already exists in map, increment its count
            // Otherwise, add it with count 1
            occurrenceMap.put(currentChar, occurrenceMap.getOrDefault(currentChar, 0) + 1);
        }
        
        return occurrenceMap;
	}
	
	public static void main(String args[]) {
		
		String input = "occurrence";
		Map<Character, Integer> occurrenceMap = findOccurrences(input);
		
		System.out.println("Occurrences of characters\n=======================");
		for (Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
			System.out.println(entry.getKey()+" -- "+entry.getValue());
		}
		
	}
}