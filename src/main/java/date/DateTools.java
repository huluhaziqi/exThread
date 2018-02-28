package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public static Date parse(String formatPattern, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPattern).parse(dateString);
    }

    public static String format(String formatPattern, Date date) throws ParseException {
        return new SimpleDateFormat(formatPattern).format(date);
    }

    public static SimpleDateFormat getSimpleDateFormat(String datePattern){
        SimpleDateFormat simpleDateFormat = null;
        simpleDateFormat = threadLocal.get();
        if(simpleDateFormat == null){
            simpleDateFormat = new SimpleDateFormat(datePattern);
            threadLocal.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }

}
