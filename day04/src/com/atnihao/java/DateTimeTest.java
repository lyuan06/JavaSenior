package com.atnihao.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1. System类中currentTimeMillis();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author nihao
 * @create 2022-11-09 22:59
 */
public class DateTimeTest {


        /*
    java.util.Date类
           |---java.sql.Date类

    1.两个构造器的使用
        >构造器一：Date()：创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象
    2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
     */


    @Test
    public void test1(){
        //1.System类中的currentTimeMillis()
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }

    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Wed Nov 09 23:11:54 CST 2022

        System.out.println(date1.getTime());//1668006786924

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1668006786924L);
        System.out.println(date2.toString());
        System.out.println(date2.getTime());

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;

        //情况二：
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());

    }

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期 --->字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.SimpleDateFormat的实例化

     */
    @Test
    public void test3() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date1 = new Date();
        System.out.println(date1);

        String format = sdf.format(date1);
        System.out.println(format);//22-11-10 上午8:51

        //解析：格式化的逆过程，字符串 ---> 日期
        Date date2 = sdf.parse(format);
        System.out.println(date2);//Thu Nov 10 08:51:00 CST 2022

        String s1 = "22-11-10 上午8:51";
        Date date3 = sdf.parse(s1);
        System.out.println(date3);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm aaa");
        //格式化
        Date date4 = new Date();
        String format1 = sdf1.format(date4);
        System.out.println(format1);//2022-11-10 09:02 上午
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date6 = sdf1.parse(format1);
        System.out.println(date6);

        Date date5 = sdf1.parse("2020-02-18 11:48 下午");
        System.out.println(date5);

    }

/*
 练习一：字符串"2020-09-08"转换为java.sql.Date
  */

    @Test
    public void test4() throws ParseException {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String s1 = "2020-09-08";
         Date date = sdf.parse(s1);
         java.sql.Date date1 = new java.sql.Date(date.getTime());
         System.out.println(date1);
     }
/*
"三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
举例：2020-09-08 ？ 总天数
 */

    @Test
    public void test5() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1990-01-01");
        Date date2 = sdf.parse("2020-09-08");
        System.out.println((date2.getTime()-date1.getTime())/(1000 * 60 * 60 * 24) + 1);
    }

 /*
    Calendar日历类(抽象类）的使用

     */
    @Test
    public void test6(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//class java.util.GregorianCalendar
        System.out.println(calendar);

        //2.常用方法
        //get()
        int month = calendar.get(Calendar.DAY_OF_MONTH);//当前日在当前月的第多少天
        System.out.println(month);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//当前日在当前年的第多少年

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_YEAR,12);
        int year = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(year);

        //add()
        calendar.add(Calendar.DAY_OF_YEAR,-3);
        int year1 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(year1);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }

}
