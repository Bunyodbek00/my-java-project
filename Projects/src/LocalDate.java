import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static String processDate(String dateStr, int days, String operation) {
        // Write your code here
        LocalDate date = null;
        try {
            date = LocalDate.parse(dateStr);  // ✅
        } catch(DateTimeParseException e) {
            return "Invalid date format";
        }


        if(operation.equals("add")){
            date = date.plusDays(days);
        }
        else if(operation.equals("subtract")){
            date = date.minusDays(days);
        }
        else {
            return "Invalid operation";
        }
        return "Original: " + dateStr + ", New: " + date + ", Day of week: " + date.getDayOfWeek();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateStr = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        
        System.out.println(processDate(dateStr, days, operation));
    }
}
