package net.messi.early.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String REGEX = ".*insert\\u0020.*||.*update\\u0020.*||.*delete\\u0020.*";

    public static String getCurrentTime() {
        Date date = new Date();
        return new SimpleDateFormat("YMdHm").format(date);
    }

    //将长整型数字转换为日期格式的字符
    public static String numToDate(long time, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date(time);
        return dateFormat.format(date);
    }

    //将日期格式的字符串转换为长整型
    public static long dateToNum(String date, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(date).getTime();
    }

    public static void main(String[] args) throws Exception {
//            System.out.println(System.currentTimeMillis());
//            System.out.println(dateToNum(numToDate(System.currentTimeMillis(), "yyyy-MM-dd"), "yyyy-MM-dd"));
//            System.out.println(numToDate(Long.valueOf("1555084800000"),"yyyy-MM-dd"));
        System.out.println(numToDate(Long.valueOf("1563499413957"), "yyyy-MM-dd"));
    }
}
