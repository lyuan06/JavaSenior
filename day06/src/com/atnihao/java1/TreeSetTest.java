package com.atnihao.java1;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author nihao
 * @create 2022-11-12 19:53
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加数据，要求是同一个类的对象
    2.两种排序方式：自然排序，定制排序
    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals方法


     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //错误的:不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));


        //举例1：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例2：
//        set.add(new User("Tom",12));
//        set.add(new User("Jerry",32));
//        set.add(new User("Jim",2));
//        set.add(new User("Mike",65));
//        set.add(new User("Jack",3));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



    }
}
