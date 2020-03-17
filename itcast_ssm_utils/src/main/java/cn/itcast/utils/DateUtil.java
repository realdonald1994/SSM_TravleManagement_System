package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date->String
 * String->Date
 */
public class DateUtil {

    /**
     * Date->String
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String out = sdf.format(date);
        return out;
    }

    /**
     * String->Date
     * @param str
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(str);
        return date;
    }
}
