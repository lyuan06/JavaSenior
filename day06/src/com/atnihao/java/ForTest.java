package com.atnihao.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5.0新增foreach循环，用于遍历集合、数组
 *
 * @author nihao
 * @create 2022-11-11 19:12
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        //for(集合元素类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    //foreach遍历数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};

        //for(数组元素类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

        for(String s : arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//MM 原因：增强for循环中是s被修改了，与arr[]无关
        }
    }
}
