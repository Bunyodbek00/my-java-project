import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static String processDateTime(String dateTimeStr, int amount, String unit, String operation) {
        // Write your code here
        LocalDateTime dateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try{
            dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        } catch(DateTimeParseException e){
            return "Invalid date time format";
        }
        
        if(!operation.equals("add") && !operation.equals("subtract")){
            return "Invalid operation";
        }

        if(unit.equals("hours") && operation.equals("add")){
            dateTime = dateTime.plusHours(amount);
        }
        else if(unit.equals("hours") && operation.equals("subtract")){
            dateTime = dateTime.minusHours(amount);
        }
        else if(unit.equals("days") && operation.equals("add")){
            dateTime = dateTime.plusDays(amount);
        }
        else if(unit.equals("days") && operation.equals("subtract")){
            dateTime = dateTime.minusDays(amount);
        }
        else if(unit.equals("months") && operation.equals("add")){
            dateTime = dateTime.plusMonths(amount);
        }
        else if(unit.equals("months") && operation.equals("subtract")){
            dateTime = dateTime.minusMonths(amount);
        }
        else{
            return "Invalid unit";
        }
        
        return "Original: " + dateTimeStr + ", New: " + dateTime.format(formatter) + ", Day: " + dateTime.getDayOfWeek();  
    }            
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeStr = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        String unit = scanner.nextLine();
        String operation = scanner.nextLine();
        
        System.out.println(processDateTime(dateTimeStr, amount, unit, operation));
    }
}
