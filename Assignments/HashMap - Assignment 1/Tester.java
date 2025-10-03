import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Tester {
    
    public static List<String> sortSales(Map<String, Integer> sales) {
        // Convert entries to a list and sort by value (descending)
        return sales.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
    }

    public static void main(String args[]) {
        Map<String, Integer> sales = new HashMap<String, Integer>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);
        
        List<String> employees = sortSales(sales);
        
        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employees) {
            System.out.println(employeeName);
        }
    }
}
