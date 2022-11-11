package com.atnihao.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组、都是对多个数据进行存储操作的结构，简称Java容器
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及持久化的存储
 *
 * 2.1数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，它的长度就确定了
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *      比如：String[] arr,int[] arr1; Object[] arr2;
 * 2.2数组存储多个数据方面的缺点：
 *      > 一但初始化以后，它的长度就不可以被修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便
 *      > 获取数组中实际元素个数，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序，不可重复的需求，不能满足
 *
 * 二、集合框架
 *      |------Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：有序的，可重复的数据。   -->“动态数组”
 *              |---ArrayList、LinkedList、Vector
 *          |----Set接口：无序的，不可重复的数据    -->高中讲的“集合”
 *              |---HashSet、LinkHashSet、TreeSet
 *
 *      |------Map接口：双列集合，用来存储一对(key-value)一对的数据  -->高中函数：y=f(x)
 *          |----HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 *
 * 三、Collection接口中方法的使用
 *

 * @author nihao
 * @create 2022-11-11 13:01
 */
public class CollectionTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1):将coll1集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll.add("456");
        coll.add("BB");

        coll.addAll(coll1);
        System.out.println(coll.size());//6
        System.out.println(coll);

        //clear():清空集合的数据
        coll.clear();

        //isEmpty():判断当前集合是否为空，是否有元素
        System.out.println(coll.isEmpty());



    }

}
