package com.atnihao.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK8中日期时间API测试
 *
 * @author nihao
 * @create 2022-11-10 9:47
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2022,11,10);
        System.out.println(date1);//和当前日期有偏移
    }

/*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
     @Test
     public void test1(){
         //now():获取当前的日期、时间、日期+时间
         LocalDate localDate = LocalDate.now();
         LocalTime localTime = LocalTime.now();
         LocalDateTime localDateTime = LocalDateTime.now();

         System.out.println(localDate);
         System.out.println(localTime);
         System.out.println(localDateTime);

         //of():设置指定的年、月、日、时、分、秒。没有偏移量
         LocalDate localDate1 = LocalDate.of(2002, 12, 29);
         System.out.println(localDate1);

         //getXxx():获取相关属性
         System.out.println(localDate1.getDayOfMonth());
         System.out.println(localDate1.getDayOfWeek());
         System.out.println(localDate1.getDayOfYear());

         //体现不可变性
         //withXxx():设置相关的属性
         LocalDate localDate2 = localDate1.withDayOfMonth(5);
         System.out.println(localDate1);
         System.out.println(localDate2);

         //plusXxx()
         //不可变
         LocalDate localDate3 = localDate1.plusDays(5);
         System.out.println(localDate3);
         System.out.println(localDate1);

         //minusXxx
         LocalDate localDate4 = localDate1.minusDays(5);
         System.out.println(localDate1);
         System.out.println(localDate4);
     }
     /*
    Instant的使用
    类似于 java.util.Date类

     */
     @Test
    public void test2(){
         //now():获取本初子午线对应的标准时间
         Instant instant = Instant.now();
         System.out.println(instant);//2022-11-10T06:38:31.294Z

         //添加时间的偏移量atOffset()
         OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
         System.out.println(offsetDateTime);

         //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
         long l = instant.toEpochMilli();
         System.out.println(l);

         //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
         Instant instant1 = Instant.ofEpochMilli(12314154645L);
         System.out.println(instant1);
     }
     /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat

     */
     @Test
     public void test3(){
         //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
         DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
         //格式化:日期-->字符串
         LocalDateTime localDateTime = LocalDateTime.now();
         String format = formatter.format(localDateTime);
         System.out.println(format);
         System.out.println(localDateTime);

         //解析：字符串 -->日期
         TemporalAccessor parse = formatter.parse(format);
         System.out.println(parse);

         //        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
         DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
         //格式化
         String format1 = formatter1.format(LocalDate.now());
         System.out.println(format1);

         //       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
         //格式化
         String format2 = formatter2.format(localDateTime.now());
         System.out.println(format2);

         //解析
         TemporalAccessor parse1 = formatter2.parse("2022-11-19 15:03:23");
         System.out.println(parse1);


     }


}
