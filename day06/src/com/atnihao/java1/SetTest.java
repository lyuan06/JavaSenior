package com.atnihao.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *1.Set框架结构
 *      |------Collection接口：单列集合，用来存储一个一个的对象
 *          |----Set接口：无序的，不可重复的数据    -->高中讲的“集合”
 *              |---HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                  |---LinkHashSet：作为HashSet的子类，遍历其内部数据时，可以按添加的顺序遍历
 *              |---TreeSet：可以按照添加对象的某些属性，进行排序
 *
 *     1.Set接口中没有额外的定义新的方法，使用的都是Collection中声明过的方法
 *     2.要求：向Set中添加数据，其所在的类一定要重写HashCode()和equals()方法
 *       要求：重写的

 * @author nihao
 * @create 2022-11-12 14:50
 */
public class SetTest {

    /*
    以HashSet为例
    一、Set :存储无序的、不可重复的
    1.无序性:不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
    2.不可重复性:保证添加的元素按照equals()判断时，不能返回true，即相同的元素只能添加一个

    二、添加元素的过程：以HashSet为例
    我们向HashSet中添加元素a，首先调用元素a所在类的HashCode()方法，计算a的哈希值
    此哈希值接着通过某种算法，计算出在HashSet底层数组中的存放位置（即为索引位置），判断
    数组此位置上是否已经有元素：
    如果此位置没有其他元素，则元素a添加成功---情况一
    如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的哈希值：
                                                                如果哈希值不相同，则a添加成功---情况2
                                                                如果哈希值相同，进而需要调用元素a所在类的equals方法
                                                                        equals方法返回true，元素a添加失败
                                                                        equals方法放回false，元素a添加成功--情况三
     说明：对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上的元素以链表的方式进行存储
          jdk7：元素a放到数组中，指向原来的元素
          jdk8：原来的元素在数组中，指向元素a
     HashSet底层：数组+链表
     */

    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        set.add(129);
        set.add(123);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet要高于HashSet
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        set.add(129);
        set.add(123);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());//输出结果的顺序是添加元素的顺序，但是不代表它是有序的
        }
    }
}
