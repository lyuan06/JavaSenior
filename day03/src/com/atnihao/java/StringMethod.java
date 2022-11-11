package com.atnihao.java;

import org.junit.Test;

/**
 * @author nihao
 * @create 2022-11-09 9:47
 */
public class StringMethod {




    /*
boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

注：indexOf和lastIndexOf方法如果未找到都是返回-1

     */

    @Test
    public void test3(){
        String s1 = "helloworld";

        System.out.println(s1.endsWith("z"));//false
        System.out.println(s1.startsWith("h"));//true
        System.out.println(s1.startsWith("o",5));

        System.out.println(s1.contains("llo"));
        System.out.println(s1.indexOf("world"));
        System.out.println(s1.indexOf("lo",7));

        String s2 = "helloworldlo";
        System.out.println(s2.lastIndexOf("lo"));
        System.out.println(s2.lastIndexOf("lo",3));



    }

//    int length()：返回字符串的长度： return value.length
//    char charAt(int index)： 返回某索引处的字符return value[index]
//    boolean isEmpty()：判断是否是空字符串：return value.length == 0
//    String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
//    String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
//    String trim()：返回字符串的副本，忽略前导空白和尾部空白
//    boolean equals(Object obj)：比较字符串的内容是否相同
//    boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
//    String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
//    int compareTo(String anotherString)：比较两个字符串的大小
//    String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
//    String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = s1.concat("123");
        System.out.println(s3);

        String s4 = "abc";
        String s5 = "abe";
        int compareTo = s4.compareTo(s5);
        System.out.println(compareTo);

        System.out.println(s1.substring(5));

        System.out.println(s1.substring(5,7));//区间是左闭右开



    }

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(5));
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串

        String s3 = "    He llo world   ";
        String s4 = s3.trim();
        System.out.println(s3);
        System.out.println(s4);
    }
}
