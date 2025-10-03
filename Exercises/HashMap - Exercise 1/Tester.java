import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

class Student {
    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        // Implement your logic here and change the return statement accordingly
        if (studentMarks == null || studentMarks.isEmpty()) {
            return new HashMap<>(); // Return an empty map for empty or null input
        }

        double maxScore = Double.MIN_VALUE;
        double minScore = Double.MAX_VALUE;
        
        // Find the actual max and min scores first
        for (double score : studentMarks.values()) {
            if (score > maxScore) {
                maxScore = score;
            }
            if (score < minScore) {
                minScore = score;
            }
        }

        Map<String, Double> maxMinScorers = new HashMap<>();

        // Iterate again to find all students with the max and min scores
        for (Entry<String, Double> entry : studentMarks.entrySet()) {
            if (entry.getValue().equals(maxScore)) {
                maxMinScorers.put(entry.getKey(), entry.getValue());
            }
            if (entry.getValue().equals(minScore)) {
                maxMinScorers.put(entry.getKey(), entry.getValue());
            }
        }
        
        return maxMinScorers;
    }
}

class Tester {

	public static void main(String args[]) {
		Map<String, Double> studentMarks = new HashMap<String, Double>();
	    studentMarks.put("Lily", 90.0);
		studentMarks.put("Robin", 68.0);
		studentMarks.put("Marshall", 76.5);
		studentMarks.put("Neil", 67.0);
		studentMarks.put("Ted", 92.0);
		
		Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);
		
		System.out.println("Details of Top Scorers & Low Scorers\n====================================");
		for (Entry<String, Double> entry : maxMinScorers.entrySet()) {
			System.out.println(entry.getKey()+" -- "+entry.getValue());
		}
		
	}
}