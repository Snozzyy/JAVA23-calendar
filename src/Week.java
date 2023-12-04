import java.time.*;
import java.util.*;

public class Week {

    private static LinkedHashMap dayDates() {
        // Gets this mondays date
        LocalDate date = LocalDate.now();
        while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
            date = date.minusDays(1);
        }

        // LinkedHashMap containing weekdays and their date. LinkedHasMap used because its in put-order
        LinkedHashMap<String, LocalDate> thisWeek = new LinkedHashMap<String, LocalDate>();
        thisWeek.put("Monday", null);
        thisWeek.put("Tuesday", null);
        thisWeek.put("Wednesday", null);
        thisWeek.put("Thursday", null);
        thisWeek.put("Friday", null);
        thisWeek.put("Saturday", null);
        thisWeek.put("Sunday", null);

        // Set this week's dates as values in HashMap
        for (Map.Entry<String, LocalDate> entry : thisWeek.entrySet()) {
            entry.setValue(date);
            date = date.plusDays(1);
        }

        return thisWeek;
    }

    // Takes a weekday as argument and returns the date for that weekday
    public static LocalDate getDate(String day) {
        return (LocalDate) dayDates().get(day);
    }
}