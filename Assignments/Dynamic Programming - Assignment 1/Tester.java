import java.util.ArrayList;
import java.util.List;

class Tester {
    
    static int count = 0;
    
    public static void findWordSegments(List<String> wordsList, String inputString) {
        count = 0; // Reset count for each call
        backtrack(wordsList, inputString, 0);
    }
    
    private static void backtrack(List<String> wordsList, String inputString, int start) {
        // If we've reached the end of the string, we found a valid segmentation
        if (start == inputString.length()) {
            count++;
            return;
        }
        
        // Try all possible words that match the current position
        for (String word : wordsList) {
            // Check if the word matches the substring starting at current position
            if (start + word.length() <= inputString.length()) {
                String substring = inputString.substring(start, start + word.length());
                if (substring.equals(word)) {
                    // Recursively try to segment the remaining string
                    backtrack(wordsList, inputString, start + word.length());
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<String>();
        wordsList.add("i");
        wordsList.add("like");
        wordsList.add("pizza");
        wordsList.add("li");
        wordsList.add("ke");
        wordsList.add("pi");
        wordsList.add("zza");
        
        String inputString = "ilikepizza";
        findWordSegments(wordsList, inputString);
        System.out.println("Number of segments: " + count); // Expected: 4
        
        // Test with the provided sample
        List<String> wordsList2 = new ArrayList<String>();
        wordsList2.add("i");
        wordsList2.add("like");
        wordsList2.add("pizza");
        wordsList2.add("ii");
        wordsList2.add("ke");
        wordsList2.add("pi");
        wordsList2.add("zza");
        
        String inputString2 = "likepizza";
        findWordSegments(wordsList2, inputString2);
        System.out.println("Number of segments: " + count); // Expected: 4
        
        // Test with second sample
        List<String> wordsList3 = new ArrayList<String>();
        wordsList3.add("java");
        wordsList3.add("is");
        wordsList3.add("fun");
        wordsList3.add("ja");
        wordsList3.add("fu");
        wordsList3.add("i");
        
        String inputString3 = "fn";
        findWordSegments(wordsList3, inputString3);
        System.out.println("Number of segments: " + count); // Expected: 0
    }
}