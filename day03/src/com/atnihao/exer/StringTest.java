package com.atnihao.exer;

/**
 * @author nihao
 * @create 2022-11-07 19:45
 */

/**
 * 一道面试题
 *
 * @author shkstart
 * @create 2019 上午 11:32
 */
public class StringTest {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good---String的不可变性
        System.out.println(ex.ch);//best
    }
}
