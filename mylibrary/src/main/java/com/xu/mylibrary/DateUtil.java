package com.xu.mylibrary;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Anonymous on 2017/1/12.
 */

public class DateUtil {
    private static DateUtil dataUtil;
    private static SimpleDateFormat format;
    private static long currentTime;
    private static String dateTime;
    private static String[] time;
    private static Calendar cal = Calendar.getInstance();

    /**
     * 初始化日历时间
     * System.currentTimeMillis()速度快
     */
    public static DateUtil getInstance() {
        if (dataUtil == null) {
            dataUtil = new DateUtil();
            currentTime = System.currentTimeMillis();
            format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            time = StringUtil.split(format.format(currentTime));
        }
        return dataUtil;
    }

    /**
     * 获取当前时间
     */
    public static String getCurrentDate(String dateFormat) {
        currentTime = System.currentTimeMillis();
        format = new SimpleDateFormat(dateFormat);
        dateTime = format.format(currentTime);
        return dateTime;
    }

    /**
     * Data根据相应的格式转化成String
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String dateformat) {
        format = new SimpleDateFormat(dateformat);
        String dateString = format.format(date);
        return dateString;
    }

    /**
     * 获取当前时间+n小时
     */
    public static String getCurrentDateAddHour(String dateFormat, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, count);
        Date date = calendar.getTime();
        format = new SimpleDateFormat(dateFormat);
        dateTime = format.format(date);
        return dateTime;
    }

    /**
     * 获取当前时间+n个月
     */
    public static String getCurrentDateAddMonth(String dateFormat, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, count);
        Date date = calendar.getTime();
        format = new SimpleDateFormat(dateFormat);
        dateTime = format.format(date);
        return dateTime;
    }

    /**
     * 获取年
     */
    public String getCurrentYear() {
        return time[0];
    }

    /**
     * 获取月
     */
    public String getCurrentMouth() {
        return time[1];
    }

    /**
     * 获取天
     */
    public String getCurrentDay() {
        return time[2];
    }

    /**
     * 获取小时
     */
    public String getCurrentHour() {
        return time[3];
    }

    /**
     * 获取分钟
     */
    public String getCurrentMinute() {
        return time[4];
    }

    /**
     * 获取秒数
     */
    public String getCurrentSecond() {
        return time[5];
    }

    /**
     * 比较日期大小
     */
    public static boolean compareData(String startTime, String endTime, String dateFormat) throws ParseException {
        DateFormat df = new SimpleDateFormat(dateFormat);
        Date dt1 = df.parse(startTime);
        Date dt2 = df.parse(endTime);
        if (dt1.getTime() > dt2.getTime()) {
            return false;
        } else if (dt1.getTime() <= dt2.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 获取当年一共有多少周
     */
    public static int getWeeksInYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY); //设置每周的第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//每周从周一开始
        cal.set(Calendar.YEAR, year + 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.add(Calendar.DAY_OF_MONTH, -(6 + cal.get(Calendar.DAY_OF_WEEK)));
        int weeks = cal.get(Calendar.WEEK_OF_YEAR);
        return weeks;
    }

    /**
     * 获取当前日期在当年第几周
     */
    public static int getWeekInYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * 时间格式转化
     */
    public static String toFotmat(String s1, String format1, String format2) {
        SimpleDateFormat format = null;
        Date date = null;
        try {
            format = new SimpleDateFormat(format1);
            date = format.parse(s1);
            format = new SimpleDateFormat(format2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format.format(date);
    }

    /**
     * 将秒数转为时分秒
     *
     * @param second
     * @return
     */
    public static String changeSecond(int second) {
        int h = 0;
        int d = 0;
        int s = 0;
        String hh = "";
        String dd = "";
        String ss = "";
        int temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        if (h < 10) {
            hh = "0" + h;
        } else {
            hh = h + "";
        }
        if (d < 10) {
            dd = "0" + d;
        } else {
            dd = d + "";
        }
        if (s < 10) {
            ss = "0" + s;
        } else {
            ss = s + "";
        }
        return hh + ":" + dd + ":" + ss + "";
    }

    public static String getLongToString(long time, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date d1 = new Date(time);
        Log.d("xxxxx",format.format(d1));
        return format.format(d1);
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Long date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date_str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前的时间戳
     *
     * @return
     */
    public static Long getTimeStame() {
        long time = System.currentTimeMillis();
        return time;
    }

    /**
     * 格式化时间戳
     * @param time
     * @return
     */
    public static String getDateTime(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hms = formatter.format(time);
        return hms;
    }

}
