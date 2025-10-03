import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Tester {
    
    public static Map<String, Integer> mergeMaps(Map<String, Integer> mapOne, Map<String, Integer> mapTwo){
        // Create a new LinkedHashMap to maintain insertion order
        Map<String, Integer> mergedMap = new HashMap<>();
        
        // First, add all entries from mapOne
        for (Entry<String, Integer> entry : mapOne.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }
        
        // Then, add non-duplicate entries from mapTwo
        for (Entry<String, Integer> entry : mapTwo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            // If key doesn't exist in mapOne, add it normally
            if (!mergedMap.containsKey(key)) {
                mergedMap.put(key, value);
            }
        }
        
        // Finally, add duplicate entries with "New" suffix only if values are different
        for (Entry<String, Integer> entry : mapTwo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            // If key exists in mapOne (duplicate)
            if (mapOne.containsKey(key)) {
                Integer mapOneValue = mapOne.get(key);
                // Only add "New" entry if values are different
                if (!value.equals(mapOneValue)) {
                    String newKey = key + "New";
                    mergedMap.put(newKey, value);
                }
            }
        }
        
        return mergedMap;
    }
    
    public static void main(String args[]) {
        Map<String, Integer> mapOne = new HashMap<String, Integer>();
        mapOne.put("Kelly", 10);
        mapOne.put("Micheal", 20);
        mapOne.put("Ryan", 30);
        
        Map<String, Integer> mapTwo = new HashMap<String, Integer>();
        mapTwo.put("Jim", 15);
        mapTwo.put("Andy", 45);
        Map<String, Integer> mergedMap = mergeMaps(mapOne, mapTwo);
        System.out.println("Merged Map\n===========");
        for (Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    
    }
}