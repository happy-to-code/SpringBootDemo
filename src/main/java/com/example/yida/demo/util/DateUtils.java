package com.example.yida.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author MaZhiCheng
 * 提供常用的日期操作的工具类
 */
public class DateUtils {

    // 星期
    public static final String[] WEEK = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    public static final String[] WEEK_SHORT = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    public static String FORMAT_Y4M = "yyyy-MM";
    public static String FORMAT_Y4MD = "yyyy-MM-dd";
    public static String FORMAT_Y4MdH = "yyyy-MM-dd HH";
    public static String FORMAT_Y4MdHm = "yyyy-MM-dd HH:mm";
    public static String FORMAT_Y4MdHms = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_Y4MdHms_POINT = "yyyy.MM.dd HH:mm:ss";
    public static String FORMAT_Y4MdHms_Compact = "yyyyMMddHHmmss";
    public static String FORMAT_HH = "HH";
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_Y4MdHms);
        return sdf.format(cal.getTime());
    }

    public static String toTimestamp(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
        return sdf.format(date.getTime());
    }

    public static String timestamp() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(cal.getTime());
    }

    public static String getYearMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_Y4M);
        return sdf.format(date);
    }

    public static String getMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(cal.getTime());
    }

    public static String today() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }

    public static String getDate(Date date, int... daysOffset) {
        if (date == null) {
            date = new Date();
        }
        if (daysOffset != null && daysOffset.length > 0) {
            date = org.apache.commons.lang3.time.DateUtils.addDays(date, daysOffset[0]);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_Y4MD);
        return sdf.format(date);
    }

    public static String getHHmm(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }

    public static String getDateTime(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

    //转化成指定的格式
    public static String getDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 是否是工作时间段，用于后台程序等
     *
     * @return
     */
    public static boolean isWorkingTime() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return (hour >= 8 && hour < 22);
    }

    /**
     * 得到当前的年月YYMM，用于生成文件夹
     *
     * @return
     */
    public static String getYearMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        return sdf.format(cal.getTime());
    }

    /**
     * 得到当前的年月YYMM，用于生成文件夹
     *
     * @return
     */
    public static String getYearMonthDay() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        return sdf.format(cal.getTime());
    }

    /**
     * 得到当前的年月YYMM，用于生成文件夹
     *
     * @return
     */
    public static int getDay() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 时间戳转date
     *
     * @param timestamp
     * @return
     */
    public static Date timestamp2date(Long timestamp) {
        return new Date(timestamp);
    }


    public static boolean isToday(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        if (year1 == year2 && month1 == month2 && day1 == day2) {
            return true;
        }
        return false;
    }

    public static Integer compareToday(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date today = formatter.parse(formatter.format(new Date()));
            Date compareDate = formatter.parse(formatter.format(date));
            //小于今天
            if (compareDate.before(today)) {
                return -1;
            }
            //大于今天
            if (compareDate.after(today)) {
                return 1;
            }
            //等于今天
            if (compareDate.equals(today)) {
                return 0;
            }
        } catch (Exception e) {
            logger.error("转换日期出错");
        }

        return null;

    }

    public static boolean isTomorrow(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(getDateAfter(new Date(), 1));
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        if (year1 == year2 && month1 == month2 && day1 == day2) {
            return true;
        }
        return false;
    }

    /**
     * 获取某时间几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 获取某时间几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 获取指定时间后几个小时的时间
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date getDateAfterHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);// 24小时制
        return cal.getTime();
    }

    /**
     * 获取某时间后几分钟的时间
     *
     * @param d
     * @param minute
     * @return
     */
    public static String getDateBeforeByMinute(Date d, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }

    /**
     * 获取上个月的年月
     *
     * @return
     */
    public static String getLastMonth(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);

        return sdf.format(cal.getTime());
    }

    /**
     * 获取本周的开始日期（周一）
     *
     * @return
     */
    public static Date getWeekdayBegin() {
        Calendar c = Calendar.getInstance();
        int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
        c.add(Calendar.DATE, -weekday);

        return c.getTime();
    }

    /**
     * 获取指定日期的开始日期（周一）
     *
     * @param date
     * @return
     */
    public static Date getWeekdayBegin(Date date) {
        int week = getWeekOfDate(date);
        int ins = 0;
        if (week == 0) {
            ins = 6;
        } else {
            ins = week - 1;
        }
        return getDateBefore(date, ins);
    }

    /**
     * 根据日期获得星期
     *
     * @param date
     * @return
     */
    public static Integer getWeekOfDate(Date date) {
        Integer[] weekDaysCode = {0, 1, 2, 3, 4, 5, 6};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDaysCode[intWeek];
    }

    /**
     * 获取本周日期列表
     *
     * @return
     */
    public static List<Date> getWeekday() {
        List<Date> list = new ArrayList<Date>();
        Date date = getWeekdayBegin();
        list.add(date);
        for (int i = 1; i <= 6; i++) {
            Date newDate = org.apache.commons.lang3.time.DateUtils.addDays(date, i);
            list.add(newDate);
        }

        return list;
    }


    /**
     * 获取指定日期的本周日期列表
     *
     * @param date1
     * @return
     */
    public static List<Date> getWeekday(Date date1) {
        List<Date> list = new ArrayList<Date>();
        Date date2 = getWeekdayBegin(date1);
        list.add(date2);
        for (int i = 1; i <= 6; i++) {
            Date newDate = org.apache.commons.lang3.time.DateUtils.addDays(date2, i);
            list.add(newDate);
        }

        return list;
    }


    /**
     * 将指定日期的时间设置为：23:59:59
     *
     * @param date
     * @return
     */
    public static Date getDateEnd(Date date) {
        String dateEnd = getDate(date) + " 23:59:59";
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_Y4MdHms);
        try {
            return format.parse(dateEnd);
        } catch (ParseException e) {
            logger.warn("日期格式转换异常");
        }
        return null;
    }

    /**
     * 是否早上：00：00-12：00
     *
     * @return
     */
    public static boolean isMorning() {
        Date now = new Date();
        String date = getDate(new Date());
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_Y4MdHms);
        try {
            Date startDate = format.parse(date + " 00:00:00");
            Date endDate = format.parse(date + " 12:00:00");

            return now.before(endDate) && now.after(startDate);
        } catch (ParseException e) {
            logger.warn("日期格式转换异常");
        }
        return false;
    }

    /**
     * 是否下午：12：00-23：59
     *
     * @return
     */
    public static boolean isAfter() {
        Date now = new Date();
        String date = getDate(new Date());
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_Y4MdHms);
        try {
            Date startDate = format.parse(date + " 12:00:00");
            Date endDate = format.parse(date + " 23:59:59");

            return now.before(endDate) && now.after(startDate);
        } catch (ParseException e) {
            logger.warn("日期格式转换异常");
        }
        return false;
    }

    public static String getWeek(Date date) {
        int day = date.getDay();
        return WEEK[day];
    }

    public static String getHour(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_HH);
        return sdf.format(date);
    }

    public static String getAmPmhhmm(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String time = sdf.format(date);

        return getAmPm(date.getHours()) + " " + time;
    }

    public static String convertDate2Str(Date date, String fmt) {
        SimpleDateFormat format = new SimpleDateFormat(fmt);
        return format.format(date);
    }

    public static String getMdWeek(Date date) {
        String md = convertDate2Str(date, "M月d日");
        int index = getWeekOfDate(date);

        return md + " " + WEEK_SHORT[index];
    }

    /**
     * 获取上午/下午
     *
     * @return
     */
    public static String getAmPm(int hours) {
        if (hours < 12) {
            return "上午";
        } else if (12 <= hours && hours < 19) {
            return "下午";
        } else {
            return "晚上";
        }
    }

    public static Date stringDeep2date(String value) {
        if (value == null) {
            return null;
        }
        // 定义预转换格式
        String[] formats = new String[]{"yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMdd", "yyyy年MM月dd日"};
        Date date;
        for (int i = 0; i < formats.length; i++) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(formats[i]);
                date = formatter.parse(value);
                return date;
            } catch (Exception e) {
            }
        }
        logger.warn("对 " + value + " 日期格式转化失败，未能识别的格式!");
        return null;
    }

    /**
     * 获取指定日期的前7天
     *
     * @return
     */
    public static List<String> getLast7Days() {
        List<String> list = new ArrayList<String>();
        Date date = new Date();
        for (int i = -6; i <= 0; i++) {
            Date newDate = org.apache.commons.lang3.time.DateUtils.addDays(date, i);
            list.add(getDate(newDate));
        }

        return list;
    }

    /**
     * 计算两个时间之间相隔几天，注意，该方法是在忽略具体时间的基础上计算的相隔天数，比如时间 “2018-12-1 23:59:59” 和 “2018-12-2 00:00:00”
     * 相隔的天数为1天，而 “2018-12-1 00:00:00” 和 “2018-12-1 23:59:59” 相隔的是0天。<br/>
     * 如果参数中 beginDate 大于 endDate，则返回的是一个这两个时间相隔天数绝对值的负数。<br/>
     * 另外注意，如果参数之一为null，则返回的是0，这个实现可能是个问题
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int daysBetween(Date beginDate, Date endDate) {

        if (beginDate == null || endDate == null) {
            //TODO 这个地方以异常的方式或者将返回值改为Integer类型此处返回null来处理是不是更好一些
            logger.warn("日期比较参数有空值！beginDate=" + beginDate + ", endDate=" + endDate);
            return 0;
        }

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(endDate);
        endDateCal.set(Calendar.HOUR_OF_DAY, 0);
        endDateCal.set(Calendar.MINUTE, 0);
        endDateCal.set(Calendar.SECOND, 0);

        Calendar beginDateCal = Calendar.getInstance();
        beginDateCal.setTime(beginDate);
        beginDateCal.set(Calendar.HOUR_OF_DAY, 0);
        beginDateCal.set(Calendar.MINUTE, 0);
        beginDateCal.set(Calendar.SECOND, 0);

        int days = ((int) (endDateCal.getTime().getTime() / 1000) - (int) (beginDateCal.getTime().getTime() / 1000)) / 3600 / 24;
        return days;
    }


    /**
     * 计算时长, 单位秒<br/>
     * 可以传入一个可变参数，在计算时长之前先对这两个时间在秒上进行四舍五入（以兼容mysql-connector-java中时间戳的四舍五入bug）
     *
     * @param beginTime
     * @param endTime
     * @param roundFirst 是否进行先舍入再计算
     * @return
     */
    public static long calculateDuration(Date beginTime, Date endTime, boolean... roundFirst) {
        if (beginTime == null || endTime == null) {
            return 0;
        }

        if (roundFirst.length > 0 && roundFirst[0]) {
            endTime = org.apache.commons.lang3.time.DateUtils.round(endTime, Calendar.SECOND);
            beginTime = org.apache.commons.lang3.time.DateUtils.round(beginTime, Calendar.SECOND);
        }
        return (endTime.getTime() - beginTime.getTime()) / 1000;
    }


    /**
     * 判断两个时间间隔多少小时,向上取整
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Long getUpIntervalHour(Date startTime, Date endTime) {
        return Math.round(Math.ceil((endTime.getTime() - startTime.getTime()) / 1000 / 60 / 60.0));
    }

    /**
     * 判断参数1的时间是不是小于参数2的时间
     *
     * @param beforeDateTime 被比较时间
     * @param afterDateTime  （不传默认为今天23：59：59）
     * @return
     */
    public static boolean lessThanEqual(Date beforeDateTime, Date... afterDateTime) {
        Date date = null;
        if (afterDateTime != null && afterDateTime.length > 0) {
            date = getDateEnd(afterDateTime[0]);
        } else {
            //设置为今天晚上23：59：59
            date = getDateEnd(new Date());
        }
        if (beforeDateTime.before(date)) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述: 获取传入日期的当月第一天或最后一天
     *
     * @param date:
     * @param flag:true=frist,false=last
     * @return java.lang.String
     * @auther qian.liu
     * @date 2019/1/17 18:30
     */
    public static String getMonthFristOrLastDay(Date date, boolean flag) {
        //获取当前月第一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (flag) {
            calendar.add(Calendar.MONTH, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return format.format(calendar.getTime());
    }
}
