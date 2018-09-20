package com.qdm.time;

import com.qdm.utils.Utils;
import org.junit.Test;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author qiudm
 * @date 2018/8/27 18:02
 * @desc
 */
public class TimeApi {

    @Test
    public void clockApiTest() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("clock.getZone() = " + clock.getZone());//获取当前时区
        System.out.println("clock.millis() = " + clock.millis());  //获取当前时间戳
    }


    @Test
    public void durationApiTest() {
        System.out.println("true = " + true);
    }


    @Test
    public void localDateApiTest() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate.toString() = " + localDate.toString());
        System.out.println("localDate BASIC_ISO_DATE format = " + localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("localDate ISO_DATE format = " + localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println("localDate.getDayOfMonth() = " + localDate.getDayOfMonth());
    }

    @Test
    public void localDateTimeApiTest() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDateTime ISO_DATE_TIME         :   " + localDateTime
                .format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println("localDateTime ISO_LOCAL_DATE_TIME   :   " + localDateTime
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        System.out.println("localDateTime ISO_LOCAL_TIME        :   " + localDateTime
                .format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println("localDateTime BASIC_ISO_DATE        :   " + localDateTime
                .format(DateTimeFormatter.BASIC_ISO_DATE));

        System.out.println("localDateTime ofPattern             :   " + localDateTime
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")));

        System.out.println("localDateTime.getDayOfMonth()       :   " + localDateTime.getDayOfMonth());

        //3天后时间
        LocalDateTime after3DaysLater = localDateTime.plusDays(3L);
        System.out.println("after3DaysLater                     :   " + after3DaysLater
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")));


        //2天前时间
        LocalDateTime before2Days = localDateTime.minusDays(2L);
        Utils.print("before2Days", before2Days
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")));

        //1个月以后
        LocalDateTime afterOneMonth = localDateTime.plus(1, ChronoUnit.MONTHS);
        Utils.print("afterOneMonth", afterOneMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")));
    }





































}
