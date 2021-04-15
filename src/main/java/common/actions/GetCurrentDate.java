package common.actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetCurrentDate {

    public String getCurrentDate(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(LocalDate.now());
    }
}
