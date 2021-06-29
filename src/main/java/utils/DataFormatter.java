package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatter {
    public static Date formatDate(String inputDate) {
        Date enteredDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
            enteredDate = sdf.parse(inputDate);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return enteredDate;
    }
}
