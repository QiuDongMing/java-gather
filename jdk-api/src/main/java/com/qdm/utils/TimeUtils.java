package com.qdm.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qiudm
 * @date 2018/10/16 9:55
 * @desc
 */
public class TimeUtils {

    /**
     * 获取当前时间距离一天结束的秒数
     * @return
     */
    public static Long getLeftSecondOfDay() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        return ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
    }


    /**
     * 获取当天的开始时间
     * @return
     */
    public static Long getTodyStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当天的结束时间
     * @return
     */
    public static Long getTodyEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }


    public static void main(String[] args) {

        System.out.println(getTodyStart());
        System.out.println(getTodyEnd());

    }













}
