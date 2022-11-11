package com.atnihao.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求Obj所在类要重写equals()
 *
 * @author nihao
 * @create 2022-11-11 15:43
 */
public class CollectionTest1 {
    @Test
    public void test(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        //1.contains(Object obj):判断集合中是否包含Obj
        //我们判断时会调用obj所在类的equals();
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("Tom")));//true：因为String中重写了equals()比的是内容
        System.out.println(coll.contains(new Person("Jerry",20)));//false：因为Person中没有重写equals()比的是地址

        //2.containsAll(Collection coll1):判断coll1中的所有元素是否都存在于当前集合中，coll1类似于coll的子集
        Collection coll1 = new ArrayList();
        System.out.println(coll.containsAll(coll1));//true：空集也是集合coll的子集

        Collection coll2 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll2));//true:coll2中的所有元素都包含于coll中
    }

    @Test
    public void test1(){
        //3.remove(Object obj):从当前集合中删除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        coll.remove(123);
        System.out.println(coll);//多个相同数据，只移除第一个

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);//没有重写equals()，移除不了，==判断两个地址不同

        //4.removeAll(Collection coll1)：差集：从当前集合中删除coll1中的所有元素
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);//[false, 231, Tom, Person{name='Jerry', age=20}]：移除了coll中与coll1集合元素相同的元素

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        //5.retainAll(Collection coll1):求交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,231.789);
        coll.retainAll(coll1);
        System.out.println(coll);

        //6.equals(Object obj):判断当前集合和形参集合中的元素是否都相等
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 ---> 数组
        //toArray():
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //拓展：数组 ---> 集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List list1 = Arrays.asList(new int[]{123, 456});
        System.out.println(list1);//[[I@78e03bb5]：将整个数组，认为是一个元素

        List list2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list2);//[123, 456]

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }

}
