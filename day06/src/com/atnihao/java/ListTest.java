package com.atnihao.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 1.List接口框架
 * |------Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：有序的，可重复的数据。   -->“动态数组”,替换原有的数组
 *              |---ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[]类型存储
 *              |---LinkedList:对于频繁的插入和删除，使用此类比ArrayList效率高，底层使用双向链表存储
 *              |---Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[]类型存储
 *
 * 2.ArrayList源码分析：
 *      2.1 JDK 7 情况下：
 *          ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *          list.add(123);//elementData[0] = new Integer(123)
 *          ...
 *          list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 *          默认情况下，扩容为原来的1.5倍，同时需要将原来的数组中的数据赋值到新的数组中。
 *
 *          结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity);//避免多次扩容，提升效率
 *
 *      2.2 JDK 8 情况下：
 *          ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *          list.add(123);//当第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData[0]中
 *          ...
 *          后续的添加和扩容操作与JDK7一样
 *
 *      2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而JDK8的ArrayList的对象的创建类似于懒汉式
 *               延迟了数组的创建，节省内存
 *
 * 3.LinkList源码分析：
 *          LinkList list = new LinkList();内部声明了Node类型的first和last属性，默认值为null
 *          list.add(123);//将123封装到Node中，创建了Node对象
 *
 *          其中，Node定义为：体现了LinkList双向链表的说法
 *            private static class Node<E> {
                E item;
                Node<E> next;
                Node<E> prev;

                Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
                }
             }
 *  4.Vector源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 *                  扩容方面：默认扩容为原来的2倍
 *
 *
 *
 *
 *
 * 面试题：比较ArrayList、LinkedList、Vector的异同
 * 同：三个类都实现了List接口，存储数据的特点相同：有序的，可重复的数据。
 * 不同：
 *
 *
 *
 *
 * @author nihao
 * @create 2022-11-12 10:12
 */
public class ListTest {

    /*
    void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中
的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定index位置的元素，并返回此元素
Object set(int index, Object ele):设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
位置的子集合

总结：常用方法
增：add(Object obj)
删：remove(int index) / remove(Object obj)
改：set(int index, Object ele)
查：get(int index)
插：add(int index, Object ele)
长度：size()
遍历：①Iterator迭代器 ②增强for循环 ③普通的循环

     */
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",15));
        list.add(456);

        System.out.println(list);//[123, 456, AA, Person{name='Tom', age=15}, 456]

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);//[123, BB, 456, AA, Person{name='Tom', age=15}, 456]

        //boolean addAll(int index, Collection eles):从index位置开始将eles中
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(1,list1);
        System.out.println(list);//[123, 1, 2, 3, BB, 456, AA, Person{name='Tom', age=15}, 456]

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));//1

        //int indexOf(Object obj):返回obj在集合中首次出现的位置，如果找不到返回-1
        System.out.println(list.indexOf(456));//5

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置,如果找不到返回-1
        System.out.println(list.lastIndexOf(456));//8

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(1);
        System.out.println(obj);//1
        System.out.println(list);//[123, 2, 3, BB, 456, AA, Person{name='Tom', age=15}, 456]

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"bb");
        System.out.println(list);//[123, bb, 3, BB, 456, AA, Person{name='Tom', age=15}, 456]

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
        List subList = list.subList(1, 5);
        System.out.println(subList);//[bb, 3, BB, 456]

        //遍历：方式一：Iterator迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历：方式二：增强for循环
        for(Object object : list){
            System.out.println(object);
        }

        //遍历：方式三：普通循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


}
