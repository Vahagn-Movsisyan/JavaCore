package homeworks.hm10medicalCenter.util;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class DateUtil {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public static Date stringToDate(String dateStr) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(dateStr);
    }

    public static String dateToString(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
