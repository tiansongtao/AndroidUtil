package com.tian.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author tiansongtao, Email:tiansongtao@up366.com
 * @date 2020/6/28 21:08
 */
public class TimeUtil {

    /**
     * 把时间毫秒值转换成指定格式的英文日期字符串
     *
     * @param milliSeconds 时长
     * @param pattern      yyyy-MM-dd HH:mm:ss yyyy年-MM月-dd日 yyyy-MM-dd E HH:mm:ss
     * @return 日期字符串
     */
    public static String formatTime(long milliSeconds, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date date = new Date(milliSeconds);
        return format.format(date);
    }

    /**
     * 把毫秒值转换成指定格式的日期字符串
     *
     * @param date    时间
     * @param pattern yyyy-MM-dd HH:mm:ss yyyy年-MM月-dd日 yyyy-MM-dd E HH:mm:ss
     *
     * @return 日期字符串
     */
    public static String formatTime(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        long milliSecond = date.getTime();
        Date nDate = new Date(milliSecond);
        return format.format(nDate);
    }

    /**
     * 根据时间戳，得到今天是星期几
     *
     * @param timeStamp
     * @return
     */
    public static String getWeek(long timeStamp) {
        int mydate = 0;
        String week = null;
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(timeStamp));
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        // 获取指定日期转换成星期几
        if (mydate == 1) {
            week = "星期日";
        } else if (mydate == 2) {
            week = "星期一";
        } else if (mydate == 3) {
            week = "星期二";
        } else if (mydate == 4) {
            week = "星期三";
        } else if (mydate == 5) {
            week = "星期四";
        } else if (mydate == 6) {
            week = "星期五";
        } else if (mydate == 7) {
            week = "星期六";
        }
        return week;
    }
}
